package inflearn;

import java.util.Scanner;

public class Q75 {
    static int[] dy;
    static int q75(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++){
            dy[i] = dy[i-2]+dy[i-1];
        }
        return dy[n];
    }

    public static void main(String[] args){
        Q75 q75 = new Q75();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.print(q75.q75(n));

    }
}
