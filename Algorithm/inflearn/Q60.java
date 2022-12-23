package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q60 {
    static int n,m,ans = Integer.MAX_VALUE;
    public void DFS(int level, int sum, Integer[] arr){
        if(sum>m){
            return;
        }
        if(level>=ans){ //왜
            return;
        }
        if(sum == m){
            ans = Math.min(ans,level);
        }
        else{
            for(int i=0; i<n; i++){
                DFS(level+1, sum+arr[i],arr);
                //DFS(level+1, sum, arr);
            }

//            DFS(level+1, sum+arr[level],arr);
//            DFS(level+1, sum, arr);
        }
    }

    public static void main(String[] args){
        Q60 q60 = new Q60();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        m=sc.nextInt();
        q60.DFS(0,0,arr);
        System.out.println(ans);
    }
}
