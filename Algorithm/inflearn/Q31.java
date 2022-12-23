package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Q31 {
    public char q31(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char value : s.toCharArray()) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : hashMap.keySet()) {
            if (hashMap.get(key) > max) {
                max = hashMap.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q31 q31 = new Q31();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(q31.q31(n, str));
    }
}
