package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1239 {
    private static int cnt = 0;

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        System.out.println(maxLength(arr));
    }

    public static int maxLength(List<String> arr) {
        return dfs(arr, "", 0);
    }

    private static int dfs(List<String> arr, String soFar, int currentDepth) {
        if (currentDepth > arr.size()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        for (char c : soFar.toCharArray()) {
            if (set.contains(c)) {
                return 0;
            }
            set.add(c);
        }

        int max = soFar.length();

        for (int i = currentDepth; i < arr.size(); i++) {
            max = Math.max(max, dfs(arr, soFar + arr.get(i), i + 1));
        }
        return max;
    }
}
