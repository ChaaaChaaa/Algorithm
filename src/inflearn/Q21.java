package inflearn;

import java.util.Scanner;

public class

Q21 {
    public int q21(int n, int[][] arr){
        int ans = Integer.MIN_VALUE;
        int hangSum=0,yeolSum=0;
        for(int i=0; i<n; i++){
            hangSum=yeolSum=0;
            for(int j=0; j<n; j++){
                hangSum += arr[i][j];
                yeolSum += arr[j][i];
            }

            ans = Math.max(ans,hangSum);
            ans = Math.max(ans,yeolSum);
        }
        hangSum=yeolSum=0;
        for(int i=0; i<n; i++){
            hangSum += arr[i][i];
            yeolSum += arr[i][n-i-1];
        }
        ans = Math.max(ans,hangSum);
        ans = Math.max(ans,yeolSum);

        return ans;
    }
    public static void main(String[] args){
        Q21 q21 = new Q21();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(q21.q21(n,arr));
    }
}
