package forstudy;

import java.util.Scanner;

public class Q9_6 {
    static int[] unionFind;

    public static int find(int v) {
        if (v == unionFind[v]) {
            return v;
        } else {
            return unionFind[v] = find(unionFind[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unionFind[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unionFind = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unionFind[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
