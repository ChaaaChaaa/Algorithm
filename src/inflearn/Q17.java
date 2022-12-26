package inflearn;

import java.util.Scanner;

public class Q17 {
    public int q17(int maxNum){
        int ans=0;
        int[] numArr = new int[maxNum+1];
        for(int i=2; i<=maxNum; i++){
            if(numArr[i] == 0){
                ans++;
                for(int j=i; j<=maxNum; j=j+i){
                    numArr[j] = 1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Q17 q17 = new Q17();
        Scanner sc = new Scanner(System.in);
        int maxNum = sc.nextInt();
        System.out.println(q17.q17(maxNum));
    }
}
