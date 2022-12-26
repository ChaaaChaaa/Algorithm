package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q65_BFS {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    public void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= 7 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[current.x][current.y] + 1; //왜?
                }
            }
        }

    }

    public static void main(String[] args) {
        Q65_BFS q65 = new Q65_BFS();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        q65.BFS(1, 1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        }
    }
}
