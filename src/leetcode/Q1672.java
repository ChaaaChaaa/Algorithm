package leetcode;

public class Q1672 {
    public static void main(String[] args) {
        //int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        int[][] accounts = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int maxResult = Integer.MIN_VALUE;

        for (int[] account : accounts) {
            int sum = 0;
            for (int j = 0; j < account.length; j++) {
                sum += account[j];
            }
            if (sum > maxResult) {
                maxResult = sum;
            }
        }
        return maxResult;
    }
}
