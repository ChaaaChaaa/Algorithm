package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q967_DFS {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 0)));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(list, n - 1, k, i);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void dfs(List<Integer> list, int n, int k, int num) {
        if (n == 0) {
            list.add(num);
            return;
        }

        List<Integer> nextDigits = new ArrayList<>();

        Integer lastDigit = num % 10;
        nextDigits.add(lastDigit + k);

        if (k != 0) {
            nextDigits.add(lastDigit - k);
        }

        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                dfs(list, n - 1, k, newNum);
            }
        }
    }
}
