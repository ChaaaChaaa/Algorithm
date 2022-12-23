package leetcode;

public class Q122 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }


    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int lastBuy = -prices[0]; //남은 잔금
        int lastSold = 0; //수익

        if (n == 0) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            int currentBuy = Math.max(lastBuy, lastSold - prices[i]);
            int currentSold = Math.max(lastSold, lastBuy + prices[i]);
            lastBuy = currentBuy;
            lastSold = currentSold;
        }

        return lastSold;
    }
}
