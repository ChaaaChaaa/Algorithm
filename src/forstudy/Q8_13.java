package forstudy;

import java.util.Scanner;

public class Q8_13 {
    static int ans = 0,n;
    static int [] dx = {1,1,1,-1,-1,-1,0,0};
    static int [] dy = {0,-1,1,0,-1,1,-1,1};
    public void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(nx>=0 && nx<n && ny>=0 && ny< n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx,ny,board);
            }
        }
    }
    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    ans++;
                    board[i][j] = 0;
                    DFS(i,j,board);
                }
            }
        }
    }
    public static void main(String[] args){
        Q8_13 q8_13 = new Q8_13();
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
