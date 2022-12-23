package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15664 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inputNumArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }
        Arrays.sort(inputNumArr, 0, n);

        NAndM10 nAndM10 = new NAndM10(n, m, inputNumArr);

        nAndM10.backTracking(0,0);
    }

}
class NAndM10 {
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr;
    private boolean[] check;


    NAndM10(int n, int m, int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
        ascArr = new int[m];
        check = new boolean[n];
    }


    void backTracking(int index, int start) {


        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ascArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {

            if (!check[i]) {
                check[i] = true;

                if (!(ascArr[index] == inputNumArr[i])) {

                    ascArr[index] = inputNumArr[i];
                    backTracking(index + 1,i);
                }
                check[i] = false;
            }
        }
        ascArr[index] = 0;
    }
}