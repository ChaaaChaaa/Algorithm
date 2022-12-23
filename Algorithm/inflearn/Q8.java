package inflearn;

import java.util.Scanner;

public class Q8 {
    public String q8(String str) {
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString();
        if (str.equals(temp)) {
            return answer;
        }
        return "NO";
    }

    public static void main(String[] args) {
        Q8 q8 = new Q8();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(q8.q8(str));
    }

}
