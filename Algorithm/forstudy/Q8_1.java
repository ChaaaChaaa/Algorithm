package forstudy;

import java.util.Scanner;

public class Q8_1 {
    static String ans="No";
    static int n,total = 0;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr){
        if(flag){
            return;
        }
        if(sum>total/2){
            return;
        }
        if(L==n){
            if((total-sum) == sum){
                ans = "YES";
                flag = true;
            }
        }else{
            DFS(L+1,sum+arr[L],arr);
            DFS(L+1,sum,arr);
        }
    }

    public static void main(String[] args) {
        Q8_1 q8_1 = new Q8_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        q8_1.DFS(0,0,arr);
        System.out.println(ans);
    }
}
