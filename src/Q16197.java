import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16197 {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final char WALL = '#';
    private static final char COIN_CURRENT_POSITION = 'o';
    private static Queue<TwoCoinsNode> queue;
    private static int n, m;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = line[j];
                if (board[i][j] == COIN_CURRENT_POSITION) {
                    queue.offer(new TwoCoinsNode(i, j, 0));
                }
            }
        }

        System.out.println(recursion());
    }


    private static int recursion() {
        while (!queue.isEmpty()) {
            TwoCoinsNode coin1 = queue.poll();
            TwoCoinsNode coin2 = queue.poll();

            if (coin1.step >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                boolean dropCoin1 = false;
                boolean dropCoin2 = false;

                int nx1 = coin1.x + dx[i];
                int ny1 = coin1.y + dy[i];
                int nx2 = coin2.x + dx[i];
                int ny2 = coin2.y + dy[i];


                if (escape(nx1, ny1)) {
                    dropCoin1 = true;
                }

                if (escape(nx2, ny2)) {
                    dropCoin2 = true;
                }

                if (dropCoin1 && dropCoin2) {
                    continue;
                }

                if (dropCoin1 || dropCoin2) {
                    //하나 떨어진 경우
                    return coin1.step + 1;
                }

                if (runToWall(nx1, ny1) && runToWall(nx2, ny2)) {
                    //벽을 만난경우
                    continue;
                }

                if (runToWall(nx1, ny1)) {
                    nx1 = coin1.x;
                    ny1 = coin1.y;
                }

                if (runToWall(nx2, ny2)) {
                    nx2 = coin2.x;
                    ny2 = coin2.y;
                }

                queue.offer(new TwoCoinsNode(nx1, ny1, coin1.step + 1));
                queue.offer(new TwoCoinsNode(nx2, ny2, coin2.step + 1));

            }
        }
        return -1;
    }


    private static boolean escape(int x, int y) {
        return x >= n || x < 0 || y >= m || y < 0;
    }

    private static boolean runToWall(int x, int y) {
        return board[x][y] == WALL;
    }
}


class TwoCoinsNode {
    int x, y, step;

    TwoCoinsNode(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
