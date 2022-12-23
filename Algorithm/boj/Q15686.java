package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15686 {
    private static int n, m;
    private static int min = Integer.MAX_VALUE;
    private static Location[] locations;
    private static ArrayList<Location> chickenRestaurant;
    private static ArrayList<Location> house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chickenRestaurant = new ArrayList<>();
        house = new ArrayList<>();

        int[][] map = new int[n][n];

        locations = new Location[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    chickenRestaurant.add(new Location(i, j));
                }
                if (map[i][j] == 1) {
                    house.add(new Location(i, j));
                }
            }
        }
        selectChickenRestaurant(0, 0);
        System.out.println(min);
    }

    private static void selectChickenRestaurant(int currentDepth, int cnt) {
        if (cnt == m) {
            int totalDistance = 0;
            for (int h = 0; h < house.size(); h++) {
                int shortestDistance = Integer.MAX_VALUE;
                for (int c = 0; c < m; c++) {
                    int rowDist = Math.abs(house.get(h).x - locations[c].x);
                    int colDist = Math.abs(house.get(h).y - locations[c].y);

                    shortestDistance = Math.min(shortestDistance, rowDist + colDist);
                }
                totalDistance += shortestDistance;
            }

            //int result = totalDistance;
            min = Math.min(min, totalDistance);
            return;
        }

        if (currentDepth == chickenRestaurant.size()) {
            return;
        }

        for (int i = currentDepth; i < chickenRestaurant.size(); i++) {
            locations[cnt] = chickenRestaurant.get(i);
            selectChickenRestaurant(i + 1, cnt + 1);
        }
    }
}


class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
