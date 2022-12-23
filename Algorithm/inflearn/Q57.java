package inflearn;

import java.util.Scanner;

public class Q57 {
    static int ans = Integer.MIN_VALUE;
    static int maxNum,dogNum;
    public void DFS(int level, int sum, int [] arr){
        if(sum > maxNum){
            return;
        }
        if(level== dogNum){
            ans = Math.max(ans,sum);
        }
        else{
            DFS(level+1,sum+arr[level],arr);
            DFS(level+1,sum,arr);
        }
    }

    public static void main(String[] args){
        Q57 q57 = new Q57();
        Scanner sc = new Scanner(System.in);
        maxNum = sc.nextInt();
        dogNum=sc.nextInt();
        int[] arr = new int[dogNum];
        for(int i=0; i<dogNum; i++){
            arr[i] = sc.nextInt();
        }
        q57.DFS(0,0,arr);
        System.out.println(ans);
    }
}
