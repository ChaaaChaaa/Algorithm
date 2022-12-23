package fortest;

import java.util.Scanner;

import forstudy.Q8_2;

public class Q2 {
    static int ans = Integer.MIN_VALUE,c,n;
    public void DFS(int level, int sum, int[] arr){
        if(sum>c){ return;}
        if(level == n){
            ans = Math.max(ans,sum);
        } else{
            DFS(level+1, sum+arr[level], arr);
            DFS(level+1, sum,arr);
        }
    }

    public static void main(String[] args){
        Q2 q8_2 = new Q2();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        q8_2.DFS(0,0,arr);
        System.out.println(ans);
    }
}
