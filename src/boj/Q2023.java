package boj;

import java.util.Scanner;

public class Q2023 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(0,n);
        System.out.println(sb);
    }

    public static void dfs(int output, int n){
        if(n==0){
            if(isPrime(output)){
                sb.append(output).append('\n');
                return;
            }
            for(int i=0; i<10; i++){
                int next = output*10+i;
                if(isPrime(next)){
                    dfs(next,n-1);
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
