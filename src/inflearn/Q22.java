package inflearn;

import java.util.Scanner;

public class Q22 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};

    public int q22(int n, int[][] arr){
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean isBongwoori = true;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 & ny<n && arr[nx][ny]>=arr[i][j]){
                        isBongwoori =false;
                        break;
                    }
                }
                if(isBongwoori){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Q22 q22 = new Q22();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(q22.q22(n,arr));
    }
}
