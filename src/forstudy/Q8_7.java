package forstudy;

import java.util.Scanner;

public class Q8_7 {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        if(n==r || r==0){
            return 1;
        }
        else{
            return dy[n][r] = DFS(n-1,r-1)+DFS(n-1,r);
        }
    }
    public static void main(String[] args) {
        Q8_7 q8_7 = new Q8_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(q8_7.DFS(n,r));
    }
}

