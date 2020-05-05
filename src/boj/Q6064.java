package boj;

import java.util.Scanner;

public class Q6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countNum = sc.nextInt();

        for (int i = 0; i < countNum; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            Cain cain = new Cain(M, N, x, y);
            cain.makeIAndMtoSame();
            cain.crossCheckCainDate();
        }
    }
}

class Cain {
    private static final int controlOfM = 1;
    private int M;
    private int N;
    private int x;
    private int y;

    Cain(int M, int N, int x, int y) {
        this.M = M;
        this.N = N;
        this.x = x;
        this.y = y;
    }

    void makeIAndMtoSame() {
        x -= controlOfM;
        y -= controlOfM;
    }

    private boolean haveYear = false;

    void crossCheckCainDate() {
        for (int i = x; i < M * N; i += M) {
            if (flagHaveYear(i)) {
                System.out.println(i + controlOfM);
                haveYear = true;
                break;
            }
        }
        dontHaveResult();
    }

    private boolean flagHaveYear(int i) {
        return ((i % N) == y);
    }

    private void dontHaveResult() {
        if (!haveYear) {
            System.out.println("-1");
        }
    }

}
