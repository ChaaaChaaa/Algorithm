package boj;

import java.util.Scanner;

public class Q1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i < 999999999; i++) {
            if (isPalindrom(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPalindrom(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        if (!sb.toString().equals(sb.reverse().toString())) {
            return false;
        }
        return true;
    }

    private static boolean isPrime(int n) {
        if(n == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
