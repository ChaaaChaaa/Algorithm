package inflearn;

import java.util.Scanner;

public class Q28 {
    public int q28(int n, int m, int[] arr) {
        int ans = 0,sum=0,lt=0;
        for(int rt=0; rt<n; rt++){
            sum+=arr[rt];
            if(sum == m){
                ans++;
            }
            while (sum>=m){
                sum -= arr[lt++];
                if(sum == m){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q28 q28 = new Q28();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(q28.q28(n, m, arr));
    }
}
