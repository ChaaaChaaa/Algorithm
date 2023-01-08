package boj;

import java.util.Scanner;

public class Q2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        int start = 1;
        int end = 1;
        int sum = 1;
        while(start<=end) {
            if(sum == N) ans++;
            if(sum < N) {
                end++; //한칸 이동
                sum += end; //확장하고
            } else if(sum >= N) {
                sum -= start; //삭제하고
                start++; // 한칸이동
            }
        }
        System.out.println(ans);
    }
}
