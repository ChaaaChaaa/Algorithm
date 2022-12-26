package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15665 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inputNumArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }
        Arrays.sort(inputNumArr, 0, n);

        NAndM11 nAndM11 = new NAndM11(n, m, inputNumArr);

        System.out.println( nAndM11.backTracking(0));
    }

}

class NAndM11 {
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr;


    NAndM11(int n, int m, int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
        ascArr = new int[m];
    }


    StringBuilder backTracking(int index) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
               sb.append(ascArr[i]).append(" ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!(ascArr[index] == inputNumArr[i])) {
                ascArr[index] = inputNumArr[i];
                ans.append( backTracking(index + 1));
            }
        }
        ascArr[index] = 0;
        return ans;
    }
}
