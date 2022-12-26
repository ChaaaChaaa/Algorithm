package boj;

import java.util.Scanner;

public class Q1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int E = sc.nextInt();
        final int S = sc.nextInt();
        final int M = sc.nextInt();

        CalculateDate calculateDate = new CalculateDate(E, S, M);
        calculateDate.bruteForceDates();
    }
}

class CalculateDate {
    private final int E;
    private final int S;
    private final int M;
    private int e = 1;
    private int s = 1;
    private int m = 1;

    CalculateDate(int E, int S, int M) {
        this.E = E;
        this.S = S;
        this.M = M;
    }

    void bruteForceDates() {
        for (int i = 1; ; i++) {

            if (e == E && s == S && m == M) {
                System.out.println(i);
                break;
            }

            increaseDates();
            resetDates();
        }
    }

    private void increaseDates() {
        e++;
        s++;
        m++;
    }

    private void resetDates() {
        if (e == 16) {
            e = 1;
        }
        if (s == 29) {
            s = 1;
        }
        if (m == 20) {
            m = 1;
        }
    }
}
