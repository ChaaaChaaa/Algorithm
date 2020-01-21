import java.util.Scanner;

public class Q2630 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ColorPaper colorPaper = new ColorPaper(arr);
        colorPaper.toFindColor(0, 0, size);
        System.out.println(colorPaper.printColor());
    }
}

class ColorPaper {
    private static final int divide = 2;
    private int[][] input;

    ColorPaper(int[][] arr) {
        this.input = arr;
    }

    private boolean flagToFindSameColor(int row, int col, int size) {
        int cur = input[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (cur != input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int blue = 0;
    private int white = 0;

    void toFindColor(int row, int col, int size) {
        if (flagToFindSameColor(row, col, size)) {
            configureColor(row, col);
        } else {
            int divideSize = size / divide;
            toFindColor(row, col, divideSize);
            toFindColor(row, col + divideSize, divideSize);
            toFindColor(row + divideSize, col, divideSize);
            toFindColor(row + divideSize, col + divideSize, divideSize);
        }
    }

    private void configureColor(int row, int col) {
        if (input[row][col] == 1) {
            blue++;
        }
        if (input[row][col] == 0) {
            white++;
        }
    }

    String printColor() {
        return white + "\n" + blue;
    }

}
