package inflearn;

import java.util.Scanner;

public class Q61 {
    static int[] pm, visit, arr;
    static int n, m;

    public void DFS(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
                System.out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    pm[level] = arr[i];
                    DFS(level + 1);
                    visit[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q61 q61 = new Q61();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        visit = new int[n];
        pm = new int[m];
        q61.DFS(0);
    }
}
