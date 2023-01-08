package boj;

import java.util.Scanner;

public class Q11720_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int ans = 0;

        for (char num : str.toCharArray()) {
            ans += num -'0';
        }
        System.out.println(ans);
    }
}
