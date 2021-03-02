package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb= new StringBuilder();

        backTrack(list, sb, 0, 0, n);
        return list;
    }

    public static void backTrack(List<String> list, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            list.add(sb.toString());
            return;
        }

        if(open<max){
            backTrack(list,sb.append("("),open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            backTrack(list,sb.append(")"),open,close+1,max);
           sb.deleteCharAt(sb.length()-1);
        }
    }
}
