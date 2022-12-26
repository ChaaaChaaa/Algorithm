package boj;

import java.util.Scanner;

public class Q1248 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int cnt = 0;
        TakeAGuess takeAGuess = new TakeAGuess(n);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = s.charAt(cnt);
                takeAGuess.changeSignToNum(x, i, j);
                cnt += 1;
            }
        }

        takeAGuess.backtracking(0);
        takeAGuess.printArr();
    }
}

class TakeAGuess {
    private static final int positiveNumber = 1;
    private static final int negativeNumber = -1;
    private static final int zero = 0;

    private static final char positiveSign = '+';
    private static final char negativeSign = '-';
    private static final char zeroSign = '0';

    private static final int startNum = 1;
    private static final int endNum = 10;

    private static final String space = " ";

    private static final int next = 1;

    private int[] ans;
    private int[][] sign;
    private int n;

    TakeAGuess(int n) {
        this.n = n;
        ans = new int[n];
        sign = new int[n][n];
    }

    void changeSignToNum(char x, int i, int j) {
        if (x == zeroSign) {
            sign[i][j] = zero;
        }
        if (x == positiveSign) {
            sign[i][j] = positiveNumber;
        }
        if (x == negativeSign) {
            sign[i][j] = negativeNumber;
        }
    }


    private boolean isRealNumber(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += ans[i];

            if (sign[i][index] == zero) {
                if (sum != zero) return false;
            } else if (sign[i][index] < zero) {
                if (sum >= zero) return false;
            } else if (sign[i][index] > zero) {
                if (sum <= zero) return false;
            }
        }
        return true;
    }


    boolean backtracking(int index) {
        if (index == n) {
            return true;
        }

        if (sign[index][index] == zero) {
            ans[index] = zero;
            return isRealNumber(index) && backtracking(index + next);
        }

        for (int i = startNum; i <= endNum; i++) {
            ans[index] = sign[index][index] * i;
            if (isRealNumber(index) && backtracking(index + next)) {
                return true;
            }
        }
        return false;
    }

    void printArr() {
        for (int i = zero; i < n; i++) {
            System.out.print(ans[i] + space);
        }
        System.out.println();
    }

}
