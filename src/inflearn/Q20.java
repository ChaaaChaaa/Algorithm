package inflearn;

import java.util.Scanner;

public class Q20 {
    public int[] q20(int n, int[] arr) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) { //나보다 크면 등수 하나씩 내려가기
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q20 q20 = new Q20();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : q20.q20(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
