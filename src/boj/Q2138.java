package boj;

import java.io.*;

public class Q2138 {
    private static int n;
    public static char[] input, target;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        backTracking(1, 0);
        input[0] ^= 1;
        input[1] ^= 1;
        backTracking(1, 1);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);

    }

    private static void backTracking(int currentDepth, int cnt) {
        if (currentDepth == n - 1) {
            //스위치x
            if (input[currentDepth] == target[currentDepth] && input[currentDepth - 1] == target[currentDepth - 1]) {
                ans = Math.min(ans, cnt);
                return;
            }
            //스위치O
            if ((input[currentDepth - 1] ^ 1) == target[currentDepth - 1] && (input[currentDepth] ^ 1) == target[currentDepth]) {
                ans = Math.min(ans, cnt + 1);
            }
            return;
        }

        if ((input[currentDepth - 1]) == target[currentDepth - 1]) {
            backTracking(currentDepth + 1, cnt);
        } else {
            input[currentDepth - 1] ^= 1;
            input[currentDepth] ^= 1;
            input[currentDepth + 1] ^= 1;
            backTracking(currentDepth + 1, cnt + 1);
            input[currentDepth - 1] ^= 1;
            input[currentDepth] ^= 1;
            input[currentDepth + 1] ^= 1;
        }
    }
}