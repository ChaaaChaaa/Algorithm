package boj;
import java.util.*;

class Q2468 {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> flood;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxCnt = Integer.MIN_VALUE;
        map = new int[n][n];
        flood = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (!flood.contains(map[i][j])) {
                    flood.add(map[i][j]);
                }
            }
        }

        for (int height : flood) {
            int seaArea = searchMap(height);
            maxCnt = Math.max(maxCnt, seaArea);
        }

        System.out.println(maxCnt);
    }

    private static int searchMap(int height) {
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] >= height) {
                    dfs(i, j, height, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, int height, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] >= height) {
                dfs(nx, ny, height, visited);
            }
        }
    }
}