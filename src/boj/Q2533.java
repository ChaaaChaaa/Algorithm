package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2533 {
    private static int node;
    private static int[][] dp;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        dp = new int[node + 1][2];

        for (int i = 0; i <= node; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < node - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        System.out.println(list);
        dp(1, -1);
        int result = Math.min(dp[1][0], dp[1][1]);
        System.out.println(result);
    }

    static void dp(int current, int parent) {
        dp[current][0] = 0; //어답터 X
        dp[current][1] = 1; //어답터 O

        for (int next : list.get(current)) {
            if (next != parent) { // next = parent 단말노드 일 수 있으므로
                dp(next, current);
                dp[current][0] += dp[next][1]; // index가 얼리가 아닌 경우 자식이 무조건 얼리어야 한다.
                dp[current][1] += Math.min(dp[next][0], dp[next][1]); //index가 얼리인 경우 자식은 얼리어도, 아니어도 된다. 둘 중 작은 것 선택
            }
        }
    }
}
