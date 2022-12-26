package inflearn;

import java.util.Scanner;

public class Q29 {
    public int q29(int n) {
        int ans = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                ans++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    ans++;
                }
            }
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q29 q29 = new Q29();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(q29.q29(n));
    }
}
