package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rest = a % 10;
            int exponentRest = b % 4;

            if (exponentRest == 0) {
                exponentRest = 4;
            }
            int ans = (int) Math.pow(rest, exponentRest) % 10;

            if (ans == 0) {
                ans = 10;
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
