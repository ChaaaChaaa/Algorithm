package programmers;

public class Friend4Block2 {
    public int solution(int m, int n, String[] board) {
        char[][] data = new char[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                data[row][col] = board[row].charAt(col);
            }
        }
        boolean isFix = true;
        int count = 0;
        while (isFix) {
            isFix = false;
            boolean[][] delete = new boolean[m][n];
            for (int row = 0; row < m - 1; row++) {
                for (int col = 0; col < n - 1; col++) {
                    if (data[row][col] == '0') {
                        continue;
                    } else if (data[row][col] == data[row][col + 1] &&
                            data[row][col] == data[row + 1][col] &&
                            data[row][col] == data[row + 1][col + 1]) {

                        System.out.println(data[row][col]);
                        System.out.println(data[row][col + 1]);
                        System.out.println(data[row + 1][col]);
                        System.out.println( data[row + 1][col + 1]);

                        System.out.println(delete[row][col]);
                        System.out.println(delete[row][col + 1]);
                        System.out.println(delete[row + 1][col]);
                        System.out.println(delete[row + 1][col + 1]);

                        isFix = true;
                        delete[row][col] = true;
                        delete[row][col + 1] = true;
                        delete[row + 1][col] = true;
                        delete[row + 1][col + 1] = true;

                        System.out.println(delete[row][col]);
                        System.out.println(delete[row][col + 1]);
                        System.out.println(delete[row + 1][col]);
                        System.out.println(delete[row + 1][col + 1]);

                    }
                }
            }
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (delete[row][col]) {
                        count += 1;

                        for (int upper = row; upper > 0; upper--) {
                            data[upper][col] = data[upper - 1][col];
                            data[upper - 1][col] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Friend4Block2 friend4Block = new Friend4Block2();
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

//        int m = 6;
//        int n = 6;
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int result = friend4Block.solution(m, n, board);
        System.out.println(result);
    }
}
