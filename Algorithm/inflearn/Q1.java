package inflearn;

import java.util.Scanner;

public class Q1 {
    public int q1(String str, char c) {
        str = str.toUpperCase();
        c = Character.toUpperCase(c);
        int cnt = 0;

        for (char x : str.toCharArray()) {
            if (x == c) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(q1.q1(str,c));
    }

}
