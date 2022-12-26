package inflearn;

import java.util.Scanner;

public class Q12 {
    public String q12(int n, String s){
        String answer="";
        for(int i=0; i<n; i++){
            String temp = s.substring(0,7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(temp,2);
            answer += (char)num;
            s=s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args){
        Q12 q12 = new Q12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(q12.q12(n,str));
    }
}
