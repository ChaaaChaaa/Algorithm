package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16954 {
    private static int[] dx = {0, 1, 0, -1, 0, 1, -1, -1, 1};
    private static int[] dy = {0, 0, 1, 0, -1, 1, 1, -1, -1};
    private static int ans;
    private static char[][] map;
    private static Queue<Position> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[8][8];
        queue = new LinkedList<>();

        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        queue.add(new Position(7, 0));
        if (bfs()) {
            ans = 1;
        }
        else{
            ans = 0;
        }

        System.out.println(ans);
    }

    private static boolean bfs() {
        while (!queue.isEmpty()) {
           int size = queue.size();
           for(int t=0; t<size; t++){
               Position position = queue.poll();

               int x = position.x;
               int y = position.y;

               if(map[x][y] == '#') continue;

               for (int i = 0; i < 9; i++) {
                   int nx = dx[i] + x;
                   int ny = dy[i] + y;

                   if (isWall(nx, ny)) {
                       continue;
                   }

                   if (nx == 0 && ny == 7) {
                       return true;
                   }

                   if (map[nx][ny] != '#') {
                       queue.add(new Position(nx, ny));
                   }
               }
           }
            down();
           }
        return false;
    }

    private static void down() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 7; j >= 0; j--) {
                if (i - 1 < 0) {
                    map[i][j] = '.';
                } else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
    }


    private static boolean isWall(int nx, int ny) {
        return (nx < 0 || nx >= 8 || ny < 0 || ny >= 8);
    }
}
