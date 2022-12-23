package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16916 {
    private static int[] pi;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String baseString = br.readLine();
        String compareString = br.readLine();

        pi = new int[compareString.length()];

        getPi(compareString);
        KMP(baseString, compareString);
        System.out.println(ans);
    }

    private static void getPi(String compareString) {
        int j = 0;
        for (int i = 1; i < compareString.length(); i++) {
            while (j > 0 && compareString.charAt(i) != compareString.charAt(j)) {
                j = pi[j - 1];
            }
            while (compareString.charAt(i) == compareString.charAt(j)) {
                pi[i] = j + 1;
                j += 1;
            }
        }
    }

    private static void KMP(String baseString, String compareString) {
        int j = 0;
        for (int i = 0; i < baseString.length(); i++) {
            while (j > 0 && baseString.charAt(i) != compareString.charAt(j)) {
                j = pi[j - 1];
            }

            if (baseString.charAt(i) == compareString.charAt(j)) {
                if (j == compareString.length() - 1) {
                    ans = 1;
                    return;
                } else {
                    j++;
                }
            }
        }
    }
}
