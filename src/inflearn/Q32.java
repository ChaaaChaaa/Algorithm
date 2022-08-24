package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Q32 {
    public String q32(String s1, String s2) {
        String ans = "YES";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char key : s1.toCharArray()) {
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        for (char key : s2.toCharArray()) {
            if (hashMap.get(key) == 0 || !hashMap.containsKey(key)) {
                return "NO";
            }
            hashMap.put(key, hashMap.get(key) - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Q32 q32 = new Q32();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(q32.q32(a, b));
    }
}
