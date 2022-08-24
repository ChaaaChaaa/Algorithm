package inflearn;

import java.util.Scanner;

public class Q64 {
    static int[] combinatioin;
    static int n, m;

    public void DFS(int level, int s) {
        if (level == m) {
            for (int x : combinatioin) {
                System.out.print(x + " ");
                System.out.println();
            }
        } else {
            for (int i = s; i <= n; i++) {
                combinatioin[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Q64 q64 = new Q64();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combinatioin = new int[m];
        q64.DFS(0, 1);
    }
}
