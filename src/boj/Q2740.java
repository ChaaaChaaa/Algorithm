package boj;

import java.util.Scanner;

public class Q2740 {
    private static final String pause = " ";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();

        int[][] firstMatrix = new int[row1][col1];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                firstMatrix[i][j] = sc.nextInt();
            }
        }

        int row2 = sc.nextInt();
        int col2 = sc.nextInt();

        int[][] secondMatrix = new int[row2][col2];

        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                secondMatrix[i][j] = sc.nextInt();
            }
        }

        int[][] resultMatrix = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

                }
                System.out.print(resultMatrix[i][j] + pause);
            }
            System.out.println();
        }
    }
}
