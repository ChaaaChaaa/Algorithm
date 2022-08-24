package inflearn;

import java.util.Scanner;

public class Q3 {
    public String q3(String str) {
        String ans = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            int len = x.length();
            if(len >m){
                m=len;
                ans=x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(q3.q3(str));
    }

}
