package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int one = 0, negative = 0, positive = 0;
        int[] numArr = new int[n];
        int maxGroup = 0;

        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if (inputNum > 1) {
                positive++;
            }
            if (inputNum == 1) {
                one++;
            }
            if (inputNum < 1) {
                negative++;
            }
            numArr[i] = inputNum;
        }

        Arrays.sort(numArr);

        //음수
        for (int i = 0; i < negative - 1; i += 2) {
            maxGroup += numArr[i] * numArr[i + 1];
        }

        if (negative % 2 == 1) {
            maxGroup += numArr[negative - 1];
        }

        //양수
        for (int i = numArr.length - 1; i > numArr.length - positive; i -= 2) {
            maxGroup += numArr[i] * numArr[i - 1];
        }

        if (positive % 2 == 1) {
            maxGroup += numArr[numArr.length - positive];
        }

        System.out.println(maxGroup + one);
    }
}
