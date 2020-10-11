package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q1261_Queue {
    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};
    private static int n, m;


    private void bfs(int x, int y, int[][] map, int[][] distance) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        distance[1][1] = 0;
        while (!queue.isEmpty()) {
            Position position = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                    if (distance[nx][ny] > distance[position.x][position.y] + map[nx][ny]) {
                        distance[nx][ny] = distance[position.x][position.y] + map[nx][ny];
                        queue.add(new Position(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();

        Q1261_Queue queue = new Q1261_Queue();

        int[][] map = new int[n + 1][m + 1];
        int[][] distance = new int[n + 1][m + 1];


        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }


        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }
        queue.bfs(1,1,map,distance);
        System.out.println(distance[n][m]);
    }
}
