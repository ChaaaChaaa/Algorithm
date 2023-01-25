package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2178 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean [][] visited;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [][] map = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(map);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int[][] map) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));

        while (!queue.isEmpty()) {
            Position temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (n > nx && nx >= 0 && m > ny && ny >= 0 && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Position(nx, ny));
                    map[nx][ny] = map[temp.x][temp.y]+1;
                    visited[nx][ny] = true;
                }
            }
        }

    }
}


