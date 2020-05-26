package leetcode;

import java.util.HashMap;

public class Q1309 {
    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(freeAlphabets(s));

    }

    public static String freeAlphabets(String s) {
        HashMap<String, Character> hashMap = new HashMap<>();

        int j = 1;
        for (char ch = 'a'; ch < 'z'; ch++) {
            if (ch < 'j') {
                hashMap.put(String.valueOf(j++), ch);
            } else {
                hashMap.put(j++ + "#", ch);
            }
        }

       StringBuilder sb = new StringBuilder();
        int size = s.length()-1;
        while (size>=0){
            if(s.charAt(size) == '#'){
                sb.append(hashMap.get(s.substring(size-2,size+1)));
                size-=3;
            }
            else {
                sb.append(hashMap.get(s.substring(size,size+1)));
                size--;
            }

        }
        return sb.reverse().toString();
    }
}
