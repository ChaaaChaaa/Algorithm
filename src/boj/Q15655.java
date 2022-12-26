package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inputNumArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }

        Arrays.sort(inputNumArr, 0, n);
        NAndM6 nAndM6 = new NAndM6(n, m, inputNumArr);
        System.out.println(nAndM6.backtracking(0, 0));

    }
}

class NAndM6 {
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr;


    NAndM6(int n, int m, int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
        ascArr = new int[n];

    }

    StringBuilder backtracking(int index, int start) {

        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(inputNumArr[ascArr[i]]).append(" ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = start; i < n; i++) {

            ascArr[index] = i;
            ans.append(backtracking(index + 1, i + 1));

        }
        return ans;
    }

}
