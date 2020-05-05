package boj;

import java.util.Scanner;

public class Q3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeOfArr = sc.nextInt();
        char[][] candyArr = new char[sizeOfArr][sizeOfArr];

        for (int i = 0; i < sizeOfArr; i++) {
            candyArr[i] = sc.next().toCharArray();

        }

        CandyGame candyGame = new CandyGame(candyArr, sizeOfArr);

        candyGame.swapRowElements();
        candyGame.swapColumnsElements();
        candyGame.printResult();

    }
}

class CandyGame {
    private char[][] candyArr;
    private int sizeOfArr;

    CandyGame(char[][] candyArr, int sizeOfArr) {
        this.candyArr = candyArr;
        this.sizeOfArr = sizeOfArr;
    }

    void swapRowElements() {
        for (int i = 0; i < sizeOfArr; i++) {
            for (int j = 0; j < sizeOfArr - 1; j++) {
                swapRow(i, j);
                checkColumnsElement();
                checkRowsElement();
                swapRow(i, j);
            }
        }
    }

    private void swapRow(int idx1, int idx2) {
        char temp = candyArr[idx1][idx2];
        candyArr[idx1][idx2] = candyArr[idx1][idx2 + 1];
        candyArr[idx1][idx2 + 1] = temp;
    }

    void swapColumnsElements() {
        for (int i = 0; i < sizeOfArr; i++) {
            for (int j = 0; j < sizeOfArr - 1; j++) {
                swapColumns(j, i);
                checkColumnsElement();
                checkRowsElement();
                swapColumns(j, i);
            }
        }
    }

    private void swapColumns(int idx1, int idx2) {
        char temp = candyArr[idx1 + 1][idx2];
        candyArr[idx1 + 1][idx2] = candyArr[idx1][idx2];
        candyArr[idx1][idx2] = temp;
    }

    private int maxCount = 0;
    private int count = 1;


    private void checkRowsElement() {
        for (int k = 0; k < sizeOfArr; k++) {
            count = 1;
            for (int l = 0; l < sizeOfArr - 1; l++) {
                countContinueRowElement(k, l);
                compareMaxCount();
            }
        }
    }

    private void countContinueRowElement(int k, int l) {
        if (candyArr[k][l] == candyArr[k][l + 1]) {
            count++;
        }
        if (candyArr[k][l] != candyArr[k][l + 1]) {
            count = 1;
        }
    }

    private void checkColumnsElement() {
        for (int k = 0; k < sizeOfArr; k++) {
            count = 1;
            for (int l = 0; l < sizeOfArr - 1; l++) {
                countContinueColumnsElement(k, l);
                compareMaxCount();
            }
        }
    }


    private void countContinueColumnsElement(int k, int l) {
        if (candyArr[l][k] == candyArr[l + 1][k]) {
            count++;
        }
        if (candyArr[l][k] != candyArr[l + 1][k]) {
            count = 1;
        }
    }

    private void compareMaxCount() {
        if (count > maxCount) {
            maxCount = count;
        }
    }

    void printResult() {
        System.out.println(maxCount);
    }




}

