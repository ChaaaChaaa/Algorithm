package boj;

import java.util.Scanner;

public class Q2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;

        while (true) {
            if (k <= ((n - 2) + (m - 1)) && n >= 2 && m >= 1) {
                n -= 2;
                m -= 1;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}