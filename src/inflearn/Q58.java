package inflearn;

import java.util.Scanner;

public class Q58 {
    static int ans = Integer.MIN_VALUE, problemNum, maxTime;
    boolean flag = false;

    public void DFS(int level, int sum, int time, int[] problemSolve, int[] problemTime) {
        if (time > maxTime) {
            return;
        }
        if (level == problemNum) {
            ans = Math.max(ans, sum);
        } else {
            DFS(level + 1, sum + problemSolve[level], time + problemTime[level], problemSolve, problemTime);
            DFS(level + 1, sum, time, problemSolve, problemTime);
        }
    }

    public static void main(String[] args) {
        Q58 q58 = new Q58();
        Scanner sc = new Scanner(System.in);
        problemNum = sc.nextInt();
        maxTime = sc.nextInt();

        int[] a = new int[problemNum];
        int[] b = new int[problemNum];

        for (int i = 0; i < problemNum; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        q58.DFS(0, 0, 0, a, b);
        System.out.println(ans);
    }
}
