package inflearn;

import java.util.Scanner;

public class Q19 {
    public int q19(int n, int[] arr) {
        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                ans += cnt;
            } else {
                cnt = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q19 q19 = new Q19();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(q19.q19(n, arr));
    }
}
