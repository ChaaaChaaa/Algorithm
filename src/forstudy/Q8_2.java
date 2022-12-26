package forstudy;

import java.util.Scanner;

public class Q8_2 {
    static int ans = Integer.MIN_VALUE,c,n;
    public void DFS(int L, int sum, int[] arr){
        if(sum > c){
            return;
        }
        if(L==n){
            ans = Math.max(ans,sum);
        }else{
            DFS(L+1, sum+arr[L],arr);
            DFS(L+1, sum,arr);
        }
    }

    public static void main(String[] args){
        Q8_2 q8_2 = new Q8_2();
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
