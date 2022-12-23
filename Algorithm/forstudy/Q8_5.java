package forstudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q8_5 {
    static int n,m,ans=Integer.MAX_VALUE;
    public void DFS(int coinCount,int sum, Integer[] arr){
        if(sum>m){
            return;
        }
        if(coinCount>=ans){
            return;
        }
        if(sum == m){
            ans = Math.min(ans,coinCount);
        }else{
            for(int i=0; i<n; i++){
                DFS(coinCount+1,sum+arr[i],arr);
            }
        }
    }

    public static void main(String[] args) {
        Q8_5 q8_5 = new Q8_5();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        q8_5.DFS(0,0,arr);
        System.out.println(ans);
    }
}
