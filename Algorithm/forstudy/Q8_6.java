package forstudy;

import java.util.Scanner;

public class Q8_6 {
    static int[] pm, check, arr;
    static int n, m;

    public void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
                System.out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q8_6 q8_6 = new Q8_6();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        check = new int[n];
        pm = new int[m];
        q8_6.DFS(0);
    }
}
