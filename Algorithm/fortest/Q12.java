package fortest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


import forstudy.Q8_12;

public class Q12 {
    static int [] dx= {-1,1,0,0};
    static int [] dy = {0,0,1,-1};
    static int[][] board,distance;
    static Queue<Point1> queue = new LinkedList<>();
    static int n,m;
    public void BFS(){
        while (!queue.isEmpty()){
            Point1 temp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i]+temp.x;
                int ny = dy[i]+temp.y;
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point1(nx,ny));
                    distance[nx][ny] = distance[temp.x][temp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q12 q8_12 = new Q12();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Point1(i, j));
                }
            }
        }
        q8_12.BFS();
        boolean flag = true;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, distance[i][j]);
                }
            }
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}

class Point1{
    int x;
    int y;
    Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
}
