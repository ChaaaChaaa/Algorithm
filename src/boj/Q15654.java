package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int inputNumArr[] = new int[10];


        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }
        Arrays.sort(inputNumArr, 0, n);
        NAndM5 nAndM5 = new NAndM5(n, m,  inputNumArr);
        System.out.println(nAndM5.backtracking(0));

    }
}

class NAndM5 {
    private static final int INCREASE_COUNT = 1;
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr = new int[10];
    private boolean[] checkInputNum = new boolean[10];

    NAndM5(int n, int m,  int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
    }

    StringBuilder backtracking(int index) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(inputNumArr[ascArr[i]]).append(SPACE);
            }
            sb.append(NEW_LINE);
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (checkInputNum[i]) {
                continue;
            }
            checkInputNum[i] = true;
            ascArr[index] = i;
            ans.append(backtracking(index + INCREASE_COUNT));
            checkInputNum[i] = false;
        }
        return ans;
    }

}
