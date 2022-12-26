package inflearn;

import java.util.Scanner;

public class Q63 {
    static int[] b,p,visit;
    static int n, finalNum;
    boolean flag = false;
    int[][] dy = new int[35][35];
    public int combinateion(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combinateion(n - 1, r - 1) + combinateion(n - 1, r);
        }
    }

    public void DFS(int level, int sum) {
        if (flag) {
            return;
        }
        if (level == n) {
            if (sum == finalNum) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    if (visit[i] == 0) {
                        visit[i] = 1;
                        p[level] = i;
                        DFS(level + 1, sum + (p[level] * b[level]));
                        visit[i] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Q63 q63 = new Q63();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        finalNum = sc.nextInt();
        visit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = q63.combinateion(n - 1, i);
        }
        q63.DFS(0, 0);
    }
}
