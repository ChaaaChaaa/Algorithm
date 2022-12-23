package forstudy;

import java.util.Scanner;

public class Q8_3 {
    static int ans = Integer.MIN_VALUE, n, m;

    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if (time > m) {
            return;
        }
        if (L == n) {
            ans = Math.max(ans, sum);
        } else {
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        Q8_3 q8_3 = new Q8_3();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        q8_3.DFS(0, 0, 0, a, b);
        System.out.println(ans);
    }
}
