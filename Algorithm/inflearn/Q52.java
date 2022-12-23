package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Q52 {
    public int q52(int n, int m, int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) { //찾음
                ans = mid + 1; //n번째 이므로 indexNumber+1해서 표현한다.
                break;
            }
            if (arr[mid] > m) { //작은쪽에 있다는것을 알아서 검색범위를 좁힌다.
                rt = mid - 1;
            } else {
                lt = mid + 1; //큰쪽에 있다는것을 알아서 검색범위를 바꾼다.
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q52 q52 = new Q52();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(q52.q52(n, m, arr));
    }
}
