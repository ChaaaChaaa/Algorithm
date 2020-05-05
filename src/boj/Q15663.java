package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15663 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inputNumArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }
        Arrays.sort(inputNumArr, 0, n);

        NAndM9 nAndM9 = new NAndM9(n, m, inputNumArr);

        nAndM9.backTracking(0);
    }
}

class NAndM9 {
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr;
    private boolean[] check;


    NAndM9(int n, int m, int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
        ascArr = new int[m];
        check = new boolean[n];
    }


    void backTracking(int index) {


        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ascArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!check[i]) {
                check[i] = true;

                if (!(ascArr[index] == inputNumArr[i])) {
                    ascArr[index] = inputNumArr[i];
                    backTracking(index + 1);
                }
                check[i] = false;
            }
        }
        ascArr[index] = 0;
    }
}