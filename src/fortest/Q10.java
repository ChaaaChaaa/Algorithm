package fortest;

import java.util.Scanner;

public class Q10 {
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int[][] board;
    static int ans,n = 0 ;
    public void dfs(int x, int y){
        if(x==7 && y ==7){ ans++;}
        else{
            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx>=1 && nx<= 7 && ny>= 1 && ny<= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    dfs(nx,ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q10 q8_10 = new Q10();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        q8_10.dfs(1,1);
        System.out.print(ans);
    }
}
