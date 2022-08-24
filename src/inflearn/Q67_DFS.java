package inflearn;

import java.util.Scanner;

public class Q67_DFS {
    static int ans = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int x, int y, int[][] board) {
        for(int i=0; i<8; i++){
            int nx= x+dx[i];
            int ny= y+dy[i];

            if(nx>=0 &&ny>=0&& nx<n&& ny<n && board[nx][ny] == 1){
                board[nx][ny] = 0; //바다로 만듦
                DFS(nx,ny,board);
            }
        }
    }

    public void solution(int[][] board) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){ //육지를 만나면
                    ans++;
                    board[i][j] = 0; //출발점을 0으로 바꾸고 넘김 -> 바다로
                    DFS(i,j,board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q67_DFS q67 = new Q67_DFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(ans);
    }
}
