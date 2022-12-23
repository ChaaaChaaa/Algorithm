package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1949 {
    private static int nodeCount;
    private static List<List<Integer>> list = new ArrayList<>();
    private static int[][] dp;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        cost = new int[nodeCount + 1];
        dp = new int[nodeCount + 1][2];

        for (int i = 0; i <= nodeCount; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= nodeCount; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        dp(1, -1);
        int result = Math.max(dp[1][1], dp[1][0]);
        System.out.println(result);
    }

    private static void dp(int current, int parent) {
        for (int nextNode : list.get(current)) {
            if (nextNode != parent) {
                dp(nextNode, current);
                dp[current][1] += dp[nextNode][0]; //부모가 우수마을이면 자식은 우수마을X
                dp[current][0] += Math.max(dp[nextNode][1], dp[nextNode][0]); //부모가 우수마을ㅌ이면 자식은 우수마을X/O
            }
        }

        dp[current][1] += cost[current];
    }
}
