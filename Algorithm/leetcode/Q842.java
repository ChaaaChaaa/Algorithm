package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q842 {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("11235813"));
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        dfs(S, ans, 0);
        return ans;
    }

    public static boolean dfs(String s, List<Integer> ans, int startPoint) {
        if (startPoint == s.length() && ans.size() >= 3) {
            return true;
        }

        int num = 0;

        for (int i = startPoint; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num < 0) {
                return false;
            }
            if (ans.size() < 2 || ans.get(ans.size() - 1) + ans.get(ans.size() - 2) == num) {

                ans.add(num);
                if (dfs(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }

            if( i == startPoint && s.charAt(i) == '0'){
                return false;
            }
        }
        return false;
    }
}
