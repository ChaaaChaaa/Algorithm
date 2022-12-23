package boj;


import java.util.Scanner;


public class Q11728 {
    private static final char BLANK = ' ';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstArrSize = sc.nextInt();
        int secondArrSize = sc.nextInt();

        int[] firstArr = new int[firstArrSize];
        int[] secondArr = new int[secondArrSize];
        int[] sortedArr = new int[firstArrSize + secondArrSize];

        for (int i = 0; i < firstArrSize; i++) {
            firstArr[i] = sc.nextInt();
        }

        for (int i = 0; i < secondArrSize; i++) {
            secondArr[i] = sc.nextInt();
        }

        int right = 0;
        int left = 0;
        int index = 0;

        while (left < firstArrSize && right < secondArrSize) {
            if (firstArr[left] < secondArr[right]) {
                sortedArr[index++] = firstArr[left++];
            } else {
                sortedArr[index++] = secondArr[right++];
            }
        }

        while (left < firstArrSize) {
            sortedArr[index++] = firstArr[left++];
        }

        while (right < secondArrSize) {
            sortedArr[index++] = secondArr[right++];
        }


        StringBuilder sb = new StringBuilder();
        for (int value : sortedArr) {
            sb.append(value).append(BLANK);
        }
        System.out.println(sb.toString());
    }
}
