package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    private static int n, m;
    private static int max = Integer.MIN_VALUE;
    private static int[][] map;
    private static boolean[][] check;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 1);
                blockF(i, j);
            }
        }
        System.out.println(max);
    }

    public static void blockF(int x, int y) {
        int base = map[x][y];
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isBoundary(nx, ny)) {
                base += map[nx][ny];
                min = Math.min(min, map[nx][ny]);
                cnt += 1;
            }

            if (cnt == 4) {
                base -= min;
            }
            max = Math.max(max, base);
        }
    }

    public static void dfs(int x, int y, int sum, int cnt) {
        if (cnt > 4) {
            max = Math.max(max, sum);
            return;
        }

        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (isBoundary(nx, ny) && !check[nx][ny]) {
                dfs(nx, ny, sum + map[nx][ny], cnt + 1);
            }
        }

        check[x][y] = false;
    }

    public static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < n) && (col >= 0 && col < m);
    }
}

