import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matrixSize = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                input[i][j] = line[j] - '0';
            }
        }
        QuadTree quadTree = new QuadTree(input);
        quadTree.toFindQuadTree(0, 0, matrixSize);
        System.out.println(quadTree.printQuadTree());
    }
}

class QuadTree {
    private int[][] input;

    QuadTree(int[][] input) {
        this.input = input;
    }

    private boolean flagToFindSameMatrix(int row, int col, int size) {
        int cur = input[row][col];
        for (int i = row; (i < row + size); i++) {
            for (int j = col; (j < col + size); j++) {

                if (cur != input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private StringBuilder sb = new StringBuilder();

    void toFindQuadTree(int row, int col, int size) {
        if (flagToFindSameMatrix(row, col, size)) {
            sb.append(input[row][col]);
        } else {
            sb.append("(");
            int divide = size / 2;
            toFindQuadTree(row, col, divide);
            toFindQuadTree(row, col + divide, divide);
            toFindQuadTree(row + divide, col, divide);
            toFindQuadTree(row + divide, col + divide, divide);
            sb.append(")");
        }
    }

    String printQuadTree() {
        return sb.toString();
    }

}
