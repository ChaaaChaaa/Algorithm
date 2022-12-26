package leetcode;

import java.util.Scanner;

public class Q779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(kthGrammer(n));
    }

    private static int kthGrammer(int k){
        return Integer.bitCount(k-1)&1;
    }
}
