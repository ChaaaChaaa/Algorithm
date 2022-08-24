package inflearn;

import java.util.Scanner;

public class Q27 {
    public int q27(int n, int k, int [] arr){
        int ans = 0,sum =0;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        ans = sum;
        for(int i=k; i<n; i++){
            sum += (arr[i]-arr[i-k]);
            ans = Math.max(ans,sum);
         }
        return ans;
    }
    public static void main(String[] args){
        Q27 q27 = new Q27();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(q27.q27(n,k,arr));
    }
}
