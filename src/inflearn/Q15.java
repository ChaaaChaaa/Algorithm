package inflearn;

import java.util.Scanner;

public class Q15 {
    public String q15(int n,int[] a, int[] b){
        String ans= "";

        for(int i=0; i<n; i++){
            if(a[i]==b[i]){
                ans+="D";
            }
            else if(a[i]==1 && b[i]==3){
                ans+="A";
            }
            else if(a[i]==2 && b[i]==1){
                ans+="A";
            }
            else if(a[i] ==3 && b[i]==2){
                ans+="A";
            }
            else{
                ans+="B";
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Q15 q15 = new Q15();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }
        for(char c : q15.q15(n,a,b).toCharArray() ){
            System.out.println(c);
        }
    }
}
