package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10974_Recursion {
    private static final String BLANK_STRING = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] permutationArr = new int[count];

        for (int i = 1; i <= count; i++) {
            permutationArr[i - 1] = i;
        }

        WholePermutation_Recursion wholePermutation_recursion = new WholePermutation_Recursion(count);
        wholePermutation_recursion.backtracking(0, BLANK_STRING);
    }
}

class WholePermutation_Recursion {
    private static final String SPACE = " ";

    private boolean[] checkInputNum;
    private int count;

    WholePermutation_Recursion(int count) {
        this.count = count;
        checkInputNum = new boolean[count + 1];
    }


    void backtracking(int index, String s) {
        if (index == count) {
            System.out.println(s);
            return;
        }

        for (int i = 1; i <= count; i++) {
            if (!checkInputNum[i]) {
                checkInputNum[i] = true;
                backtracking(index + 1, s + i + SPACE);
                checkInputNum[i] = false;
            }
        }
    }
}
