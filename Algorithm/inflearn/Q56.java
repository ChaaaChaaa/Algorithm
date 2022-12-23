package inflearn;

import java.util.Scanner;

public class Q56 {
    //합이 같은 부분집합
    static String ans="NO";
    static int n,total = 0;
    boolean flag = false;

    public void q56(int level, int sum, int[] arr){
        if(flag){
            return;
        }
        if(level==n){
            if((total-sum)==sum){ //전체 더한 total에서 sum을 뺐는데 같은 값이 있다면, 부분집합완성이므로
                ans="YES";
                flag=true;
            }
        }
        else{
            q56(level+1,sum+arr[level],arr); //부분집합에 포함함
            q56(level+1,sum,arr) ; // level+1을 부분집합에 포함안함
        }
    }

    public static void main(String[] args){
        Q56 q56 = new Q56();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        q56.q56(0,0,arr);
        System.out.println(ans);
    }
}
