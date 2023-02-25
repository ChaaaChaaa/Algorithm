package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1850 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        long a =Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());
        long G = gcd(a, b);
        System.out.println("1".repeat((int)G));
    }

    public static long gcd(long max, long min){
        if(min == 0){
            return max;
        }else{
            return gcd(min,max%min);
        }
    }
}
