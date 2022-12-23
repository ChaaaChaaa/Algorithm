package leetcode;

import java.util.Arrays;

public class Q1672 {
    public static void main(String[] args) {
        //int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        int[][] accounts = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
       return Arrays.stream(accounts)
               .mapToInt(customerAccount -> Arrays.stream(customerAccount).sum())
               .max()
               .getAsInt();
    }
}
