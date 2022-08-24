package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    private static int n;
    private static int count = 0;
    private static int[] rowMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rowMap = new int[n];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int row) {
        if (row==n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            rowMap[row] = i;

            if (isCheck(row)) {
                dfs(row + 1);
            }
        }
    }

    private static boolean isCheck(int currentRow) {
        for (int i = 0; i < currentRow; i++) {
            if (rowMap[currentRow] == rowMap[i]) {
                return false;
            }

            else if (Math.abs(rowMap[currentRow] - rowMap[i]) == Math.abs(currentRow - i)) {
                return false;
            }
        }

        return true;
    }
}
