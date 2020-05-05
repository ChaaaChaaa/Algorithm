package boj;

import java.util.Scanner;

public class Q1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] minNumsArr = new int[num + 1];

        MakeOne makeOne = new MakeOne(minNumsArr);
        System.out.println(makeOne.dp(num));
    }
}

class MakeOne {
    private int[] minNumsArr;

    MakeOne(int[] minNumsArr) {
        this.minNumsArr = minNumsArr;
    }

    int dp(int num) {
        if (num <= 1) {
            return 0;
        }

        //메모리제이션
        if (minNumsArr[num] != 0) {
            return minNumsArr[num];
        }

        int minCount = Integer.MAX_VALUE;

        if (num % 3 == 0) {
            minCount = Math.min(minCount, dp(num / 3) + 1);
        }

        if (num % 2 == 0) {
            minCount = Math.min(minCount, dp(num / 2) + 1);
        }

        minCount = Math.min(minCount, dp(num - 1) + 1);

        return minNumsArr[num] = minCount;

    }

}
