package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int result = 0;

        if (a + b <= c * 2) {
            result += a * x + b * y;
        } else {
            if (x > y) {
                result += c * 2 * y;
                result += Math.min((x - y) * a, (x - y) * c * 2);
            } else {
                result += c * 2 * x;
                result += Math.min((y - x) * b, (y - x) * c * 2);
            }
        }
        System.out.println(result);
    }
}
