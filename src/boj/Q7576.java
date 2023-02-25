package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
    static int n, m, h;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] board;
    static Queue<Tomato> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        board = new int[h][n][m];

        queue = new LinkedList<Tomato>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = sc.nextInt();
                    if (board[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            Tomato t = queue.remove();

            int h = t.h; //면
            int x = t.x; //세로
            int y = t.y; //가로


            for(int i=0;i<6;i++) {
                int nx = x + dx[i]; //세로
                int ny = y + dy[i]; //가로
                int nh = h + dz[i]; //면

                //범위 안에서
                if(nx>=0 && ny>=0 && nh>=0 && nx<n && ny<m && nh<h) {
                    //토마토가 안익었으면
                    if(board[nh][nx][ny]==0) {
                        //익은 토마토 추가
                        queue.add(new Tomato(nh, nx, ny));

                        //익은 날자를 얻기위해 그 전 값에서 1 증가
                        board[nh][nx][ny] = board[h][x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i=0;i<h;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<m;k++) {
                    //토마토가 안익은게 있으면
                    if(board[i][j][k]==0) return -1;

                    //날짜 최댓값 구하기
                    result = Math.max(result, board[i][j][k]);
                }
            }
        }
        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}

class Tomato {
    int h;
    int x;
    int y;

    public Tomato(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}
