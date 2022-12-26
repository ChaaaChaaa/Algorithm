package inflearn;

import java.util.Scanner;

public class Q30 {
    public int q30(int n, int k, int[] arr) {
        int ans = 0, cnt = 0; //0을 1로 바꾼 횟수
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--; //1을 다시 0으로 바꿔둔다 라는 뜻
                }
                lt++; //바꾸고 한칸이동
            }
            ans = Math.max(ans, rt - lt + 1); //1을 연속적으로 가지고 있는 수열의 길이 rt-lt+1
        }
        return ans;
    }

    public static void main(String[] args) {
        Q30 q30 = new Q30();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(q30.q30(n, k, arr));
    }
}
