package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        String[] subtraction = br.readLine().split("-");

        for (String value : subtraction) {
            int temp = 0;
            String[] addition = value.split("\\+");
            for (String s : addition) {
                temp += Integer.parseInt(s);
            }
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
