package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q16938 {
    private static int l, r, x, n;
    private static int[] questions;
    private static int result = 0;
    private static int minInit = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        questions = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            questions[i] = Integer.parseInt(st.nextToken());
        }


        backTrack(minInit, 0, 0, 0, 0);
        System.out.println(result);
    }


    private static void backTrack(int easiest, int hardiest, int sum, int count, int currentDepth) {
        if (count >= 2) {
            if (isInRange(sum, easiest, hardiest)) {
                result++;
             }
        }

        if (currentDepth == n) {
            return;
        }

        for (int i = currentDepth; i < n; i++) {
            int min = Math.min(easiest, questions[i]);
            int max = Math.max(hardiest, questions[i]);
            backTrack(min, max, sum + questions[i], count + 1, i + 1);
        }
    }

    private static boolean isInRange(int sum, int easiest, int hardiest) {
        if (l <= sum && sum <= r && (hardiest - easiest) >= x) {
            return true;
        }
        return false;
    }
}
