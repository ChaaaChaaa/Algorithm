package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    public static void main(String[] args) {
        String s = "ababccc";
        System.out.println(partition(s));

    }

    public static List<List<String>> partition(String s) {

//        Input: s = "aab"
//        Output: [["a","a","b"],["aa","b"]]

        List<List<String>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private static void backTrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    //System.out.println("OUT s.substring(start, i + 1) "+s.substring(start, i + 1)+" start, i + 1 : "+start+" /i  :"+(i));

                }

                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backTrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }

            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            //System.out.println("low : "+low+" high: "+high+" s.charAt(low) :"+s.charAt(low)+" s.charAt(high) :"+s.charAt(high));

            if (s.charAt(low++) != s.charAt(high--)) {
               // System.out.println("OUT  low : "+low+" high: "+high+" s.charAt(low) :"+s.charAt(low)+" s.charAt(high) :"+s.charAt(high));
                return false;
            }

//            if (s.charAt(low) != s.charAt(high)) {
//                low++;
//                high--;
//                System.out.println("OUT  low : "+low+" high: "+high+" s.charAt(low) :"+s.charAt(low)+" s.charAt(high) :"+s.charAt(high));
//                return false;
//            }

        }
        return true;
    }
}
