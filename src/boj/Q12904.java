package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        StringBuilder tTemp = new StringBuilder(t);

        int sLen = s.length();
        int tLen = tTemp.length();

        while (tLen > sLen) {
            int lastChar = tLen - 1;
            if (tTemp.charAt(lastChar) == 'A') {
                tTemp.deleteCharAt(lastChar);
            } else {
                tTemp.deleteCharAt(lastChar);
                tTemp.reverse();
            }
            tLen--;
        }

        if (s.equals(tTemp.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
