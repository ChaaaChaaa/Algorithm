package fortest;

import java.util.Scanner;

public class Q13 {
    static int [] dx = {-1,-1,-1,1,1,1,0,0};
    static int [] dy = {-1,1,0,-1,1,0,-1,1};
    static int ans,n =0;
    public void dfs(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                dfs(nx,ny,board);
            }
        }
    }
    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                    ans++;
                    dfs(i,j,board);
                }
            }
        }
    }

    public static void main(String[] args){
        Q13 q8_13 = new Q13();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        q8_13.solution(arr);
        System.out.println(ans);
    }
}
