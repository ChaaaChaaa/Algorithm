package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q3052 {
    private static final int SET_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] remainderArr = new int[SET_ARRAY_SIZE];
        Remainder remainder = new Remainder(remainderArr);

        for (int i = 0; i < SET_ARRAY_SIZE; i++) {
            int num = sc.nextInt();
            remainder.divideNumber(i, num);
        }

        remainder.sortArr();
        remainder.printResult();


    }
}

class Remainder {
    private static final int DIVIDE_NUM = 42;
    private static final int SET_ARRAY_SIZE = 10;
    private int[] remainderArr;

    Remainder(int[] remainderArr) {
        this.remainderArr = remainderArr;

    }

    void divideNumber(int i, int num) {
        remainderArr[i] = num % DIVIDE_NUM;
    }

    void sortArr() {
        Arrays.sort(remainderArr);
    }

    private int compareEachNumber() {
        int prev = remainderArr[0];
        int count = 1;

        for (int i = 1; i < SET_ARRAY_SIZE; i++) {
            if (prev != remainderArr[i]) {
                count++;
            }
            prev = remainderArr[i];
        }
        return count;
    }

    void printResult() {
        System.out.println(compareEachNumber());
    }

}
