package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14225_Recursion {
    static int n;
    static boolean[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sum += arr[i];
        }

        nums = new boolean[sum + 2];

        dfs(arr, 0, 0);

        for (int i = 1; i < nums.length; i++) {
            if (!nums[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void dfs(int[] arr, int idx, int sum) {
        if (idx >= 1) {
            nums[sum] = true;
        }
        if (idx == n) {
            return;
        }

        for (int i = idx; i < n; i++) {
            dfs(arr, i + 1, sum + arr[i]);
        }
    }
}