package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Q34 {
    public int q34(String a, String b) {
        int ans = 0;
        HashMap<Character, Integer> am = new HashMap<>(); //am에서
        HashMap<Character, Integer> bm = new HashMap<>(); //bm의 아나그램을 찾는것(T 문자열)

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int L = b.length() - 1;
        for (int i = 0; i < L; i++) { //한개는 처리하지말고 세팅함
            char key = a.charAt(i);
            am.put(key, am.getOrDefault(key, 0) + 1);
        }

        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1); //왜?
            if (am.equals(bm)) { //hashmap 비교하는것 key와 value값까지 다 비교됨
               ans++;
            }
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
            lt++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Q34 q34 = new Q34();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(q34.q34(a, b));
    }
}
