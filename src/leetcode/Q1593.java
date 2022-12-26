package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q1593 {
    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("aba"));
    }
    public static int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(set, s);
    }

    private static int dfs(Set<String> set, String s) {
        System.out.println("가 : "+s);
        if (s.length() == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= s.length(); i++) {

            String sub = s.substring(0, i);
            if (!set.add(sub)) {
                System.out.println("!s.substring(i) : "+s.substring(i)+" i : "+i+" sub : "+s);
                continue;
            }
            System.out.println("s.substring(i) : "+s.substring(i)+" i : "+i+" sub : "+s);
            int next = dfs(set,s.substring(i));
            if (next >= 0) {
                res = Math.max(res, next + 1);
            }
            set.remove(sub);
        }
        return res;
    }
}
