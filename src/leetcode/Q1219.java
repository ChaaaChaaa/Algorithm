package leetcode;

public class Q1219 {
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    private static int ans = 0;

    public static void main(String[] args) {
        //int[][] grid = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        int[][] grid = {{34,0,1,0,0,0},{0,0,2,0,1,0},{5,4,3,7,4,2},{0,0,5,0,1,4},{0,0,5,0,2,3}};
        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (n == 0 && m == 0) return 0;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(grid[i][j] == 0){
                   continue;
               }
               ans = Math.max(ans, dfs(i,j,grid));
            }
        }
        return ans;
    }

    private static int dfs(int row, int col, int[][] grid) {
        int gold = grid[row][col];
        int max = grid[row][col];
        grid[row][col] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (isBoundary(nx, ny, grid) && grid[nx][ny] != 0) {
                max = Math.max(max,gold+dfs(nx,ny,grid));
            }
        }
        grid[row][col] = gold;
        return max;
    }

    private static boolean isBoundary(int row, int col, int[][] grid) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }
}
