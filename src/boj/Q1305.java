package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int electricSignSize = Integer.parseInt(br.readLine());
        String electricSignWord = br.readLine();

        int[] shortestArr = getPi(electricSignWord);
        int shortestSize = electricSignSize - shortestArr[electricSignSize - 1];
        System.out.println(shortestSize);
    }

    private static int[] getPi(String electricSignWord) {
        int[] pi = new int[electricSignWord.length()];
        int j = 0;

        for (int i = 1; i < electricSignWord.length(); i++) {
            while (j > 0 && electricSignWord.charAt(i) != electricSignWord.charAt(j)) {
                j = pi[j - 1];
            }

            if (electricSignWord.charAt(i) == electricSignWord.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
