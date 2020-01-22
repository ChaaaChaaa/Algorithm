import java.util.Scanner;

public class Q2630 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSize = sc.nextInt();

        int[][] inputArr = new int[maxSize][maxSize];

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                inputArr[i][j] = sc.nextInt();
            }
        }

        ColorPaper colorPaper = new ColorPaper(inputArr);
        colorPaper.toFindColor(0, 0, maxSize);
        System.out.println(colorPaper.printColor());
    }
}

class ColorPaper {
    private static final int divideTwo = 2;
    private static final int white = 0;
    private static final int blue = 1;

    private int[][] inputArr;

    ColorPaper(int[][] inputArr) {
        this.inputArr = inputArr;
    }

    private boolean flagToFindSameColor(int row, int col, int size) {
        int compareElement = inputArr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (compareElement != inputArr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int countOfBlue = 0;
    private int countOfWhite = 0;

    void toFindColor(int row, int col, int size) {
        if (flagToFindSameColor(row, col, size)) {
            configureColor(row, col);
            return;
        }

        int divideSize = size / divideTwo;

        //  방법1
//            toFindColor(row, col, divideSize);
//            toFindColor(row, col + divideSize, divideSize);
//            toFindColor(row + divideSize, col, divideSize);
//            toFindColor(row + divideSize, col + divideSize, divideSize);

        // 방법2

        for (int i = 0; i < divideTwo; i++) {
            for (int j = 0; j < divideTwo; j++) {
                toFindColor(row + divideSize * i, col + divideSize * j, divideSize);
            }
        }
    }


    private void configureColor(int row, int col) {
        if (inputArr[row][col] == blue) {
            countOfBlue++;
        }
        if (inputArr[row][col] == white) {
            countOfWhite++;
        }
    }

    String printColor() {
        return countOfWhite + "\n" + countOfBlue;
    }

}
