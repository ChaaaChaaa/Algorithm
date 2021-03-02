package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        backTrack(result, s, new StringBuilder(), 0, 0);
        return result;
    }

    private static void backTrack(List<String> result, String s, StringBuilder sb, int ipLength, int level) {
        if(ipLength > s.length() || level > 4) {
            return;
        } else if (level == 4 && ipLength == s.length()) {
            result.add(sb.toString());
            return;
        }

        for(int i=1; i<=3; i++){
            if(ipLength+i > s.length()){
                break;
            }
            int num = Integer.valueOf(s.substring(ipLength,ipLength+i));
            if(i == 1 || i==2 && num >=10 && num <=99 || i == 3 && num >= 100 && num <= 255){
                sb.append(num);
                if(level<3){
                    sb.append(".");
                }
                backTrack(result,s,sb,ipLength+i,level+1);
                if(level<3){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.delete(sb.length()-i,sb.length());
            }
        }
    }
}
