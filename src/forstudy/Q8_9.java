package forstudy;

import java.util.Scanner;

public class Q8_9 {
    static int[] combination;
    static int n, m;

    public void DFS(int L, int start) {
        if (L == m) {
            for (int x : combination) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                combination[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Q8_9 q_89 = new Q8_9();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        combination = new int[m];
        q_89.DFS(0,1);
    }
}
