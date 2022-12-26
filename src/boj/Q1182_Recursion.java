package boj;

import java.util.Scanner;

public class Q1182_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] inputArray = new int[n];

        for (int i = 0; i < n; i++) {
            inputArray[i] = sc.nextInt();
        }

        SumOfPartialSequence_Recursion sequenceRecursion = new SumOfPartialSequence_Recursion(inputArray, s);

        int ans = sequenceRecursion.recursion(0, 0);

        if (s == 0) {
            ans -= 1;
        }

        System.out.println(ans);

    }
}

class SumOfPartialSequence_Recursion {
    private int[] inputArray;
    private int s;

    SumOfPartialSequence_Recursion(int[] inputArray, int s) {
        this.inputArray = inputArray;
        this.s = s;
    }

    int recursion(int i, int sum) {
        if (i == inputArray.length) {
            if (sum == s) {
                return 1;
            } else {
                return 0;
            }
        }
        return recursion(i + 1, sum + inputArray[i]) + recursion(i + 1, sum);
    }
}