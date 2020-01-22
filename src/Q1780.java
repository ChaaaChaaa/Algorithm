import java.util.Scanner;

public class Q1780 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxSize = sc.nextInt();

        int[][] inputArr = new int[maxSize][maxSize];

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                inputArr[i][j] = sc.nextInt();
            }
        }

        NumberOfPapers numberOfPapers = new NumberOfPapers(inputArr);
        numberOfPapers.toCountSameNumber(0, 0, maxSize);
        System.out.println(numberOfPapers.printEachNumber());


    }
}

class NumberOfPapers {
    private static final int divideThree = 3;
    private static final int divideTwo = 2;
    private static final int minusOne = -1;
    private static final int zero = 0;
    private static final int one = 1;


    private int[][] inputArr;

    NumberOfPapers(int[][] inputArr) {
        this.inputArr = inputArr;
    }

    private boolean flagToFindSameNumber(int row, int col, int size) {
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


    void toCountSameNumber(int row, int col, int size) {

        if (flagToFindSameNumber(row, col, size)) {
            toCountEachNumber(row, col);
            return;
        }
            int divideSize = size / divideThree;

            //  방법1

            toCountSameNumber(row, col, divideSize);
            toCountSameNumber(row + divideSize, col, divideSize);
            toCountSameNumber(row + divideTwo * divideSize, col, divideSize);

            toCountSameNumber(row, col + divideSize, divideSize);
            toCountSameNumber(row + divideSize, col + divideSize, divideSize);
            toCountSameNumber(row + divideTwo * divideSize, col + divideSize, divideSize);

            toCountSameNumber(row, col + divideTwo * divideSize, divideSize);
            toCountSameNumber(row + divideSize, col + divideTwo * divideSize, divideSize);
            toCountSameNumber(row + divideTwo * divideSize, col + divideTwo * divideSize, divideSize);


            //  방법2

//            for (int i = 0; i < divideThree; i++) {
//                for (int j = 0; j < divideThree; j++) {
//                    toCountSameNumber(row + divideSize * i, col + divideSize * j, divideSize);
//                }
//            }

    }

    private int countOfMinusOne = 0;
    private int countOfZero = 0;
    private int countOfOne = 0;


    private void toCountEachNumber(int row, int col) {
        if (inputArr[row][col] == minusOne) {
            countOfMinusOne++;
        }

        if (inputArr[row][col] == zero) {
            countOfZero++;
        }

        if (inputArr[row][col] == one) {
            countOfOne++;
        }
    }

    String printEachNumber() {
        return countOfMinusOne + "\n" + countOfZero + "\n" + countOfOne;
    }
}
