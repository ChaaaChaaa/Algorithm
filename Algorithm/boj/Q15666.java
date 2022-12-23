package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15666 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inputNumArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }
        Arrays.sort(inputNumArr, 0, n);

        NAndM12 nAndM12 = new NAndM12(n, m, inputNumArr);

        System.out.println( nAndM12.backTracking(0,0));
    }

}

class NAndM12 {
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr;


    NAndM12(int n, int m, int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
        ascArr = new int[m];
    }


    StringBuilder backTracking(int index, int start) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(ascArr[i]).append(" ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = start; i < n; i++) {
            if (!(ascArr[index] == inputNumArr[i])) {
                ascArr[index] = inputNumArr[i];
                ans.append( backTracking(index + 1,i));
            }
        }
        ascArr[index] = 0;
        return ans;
    }
}

