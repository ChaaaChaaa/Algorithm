package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17088 {
    private static int n;
    static int min = Integer.MAX_VALUE;
    private static int[] nums = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int gap = nums[0] - nums[1];

        backTrack(1, nums[0], gap, 0, "기본1 ");
        backTrack(1, nums[0] + 1, gap + 1, 1, "더하기1 ");
        backTrack(1, nums[0] - 1, gap - 1, 1, "빼기1 ");

        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(min);
        }

    }

    private static void backTrack(int currentDepth, int prev, int gap, int cnt, String flag) {
        if (n == currentDepth) {
            min = Math.min(min, cnt);
            return;
        }

        if (currentDepth == 1) {
            backTrack(2, nums[1], gap, cnt, "기본2 ");
            backTrack(2, nums[1] + 1, gap - 1, cnt + 1, "더하기2 ");
            backTrack(2, nums[1] - 1, gap + 1, cnt + 1, "빼기2 ");

        } else {
            int val = nums[currentDepth];
            int gapNormal = prev - val;
            int gapAdd = prev - (val + 1);
            int gapSubtract = prev - (val - 1);

            if (gap == gapNormal) {
                backTrack(currentDepth + 1, val, gapNormal, cnt, "기본3 ");
            }

            if (gap == gapAdd) {
                backTrack(currentDepth + 1, val + 1, gapAdd, cnt + 1, "더하기3 ");

            }

            if (gap == gapSubtract) {
                backTrack(currentDepth + 1, val - 1, gapSubtract, cnt + 1, "빼기3 ");
            }
        }
    }
}
