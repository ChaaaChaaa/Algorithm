package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Q242 {
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        System.out.println(isAnagram(s, t));
    }


    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int num : alphabet) {
           if( num != 0){
               return false;
           }
        }

        return true;
    }
}
