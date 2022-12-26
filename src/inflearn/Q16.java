package inflearn;

import java.util.Scanner;

public class Q16 {
    public int[] q16(int maxCount) {
        int[] ans = new int[maxCount];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < maxCount; i++) {
            ans[i] = ans[i - 2] + ans[i - 1];
        }
        return ans;
    }

//    public void q16(int maxCount){
//        int a=1, b=1,c;
//        System.out.println(a+" "+b);
//        for(int i=2; i<maxCount; i++){
//            c=a+b;
//            System.out.print(c+" ");
//            a=b;
//            b=c;
//        }
//    }

//    public  int DFS(int n){
//        if(n==1){
//            return 1;
//        }
//        else if(n==2){
//            return 1;
//        }
//        else return DFS(n-2)+DFS(n-1);
//    }

    static int[] fibo;

    public int DFSWithMemorization(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFSWithMemorization(n - 2) + DFSWithMemorization(n - 1);
        }
    }


    public static void main(String[] args) {
        Q16 q16 = new Q16();
        Scanner sc = new Scanner(System.in);
        int maxCount = sc.nextInt();
        for (int n : q16.q16(maxCount)) {
            System.out.print(n + " ");
        }
    }
}
