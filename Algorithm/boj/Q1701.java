package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cubeLang = bufferedReader.readLine();
        String cutBackward = "";
        int ans = 0;


        for (int i = cubeLang.length() - 1; i >= 0; i--) {
            cutBackward = cubeLang.charAt(i) + cutBackward;
            int[] temp = getPi(cutBackward);
            int size = temp.length;

            for (int j = 0; j < size; j++) {
                if (temp[j] > ans) {
                    ans = temp[j];
                }
            }
        }
        System.out.println(ans);

    }

    private static int[] getPi(String cutBackward) {
        int[] pi = new int[cutBackward.length()];
        int j = 0;


        for (int i = 1; i < cutBackward.length(); i++) {
            while (j > 0 && cutBackward.charAt(i) != cutBackward.charAt(j)) {
                j = pi[j - 1];
            }
            if (cutBackward.charAt(i) == cutBackward.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
