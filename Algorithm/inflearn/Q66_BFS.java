package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q66_BFS {
    //토마토
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, spendTime;
    static int hang, yeol;
    static Queue<Point> queue = new LinkedList<>();

    public void BFS() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx >= 0 && ny >= 0 && nx <= hang && ny <= yeol && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    spendTime[nx][ny] = spendTime[current.x][current.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q66_BFS q66 = new Q66_BFS();
        Scanner sc = new Scanner(System.in);
        hang = sc.nextInt();
        yeol = sc.nextInt();
        board = new int[hang][yeol];
        spendTime = new int[hang][yeol];

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < yeol; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) { //익은토마토
                    queue.offer(new Point(i, j)); //0Level
                }
            }
        }

        q66.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < yeol; j++) {
                if (board[i][j] == 0) { //다 했는데도, 익지않은 토마토가 있다.
                    flag = false; //-1 출력
                }
            }
        }

        if (flag) {
            for (int i = 0; i < hang; i++) {
                for (int j = 0; j < yeol; j++) {
                    answer = Math.max(answer, spendTime[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
