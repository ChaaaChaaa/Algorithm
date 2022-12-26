package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int result = 0;

        if (col == 1) {
            result = 0;
        } else if (col == 2) {
            result = Math.min(4, (row + 1) / 2);
        } else if (row < 7) {
            result = Math.min(row, 4);
        } else {
            result = row - 7 + 5;
        }

        System.out.println(result);
    }
}

