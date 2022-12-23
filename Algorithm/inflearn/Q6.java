package inflearn;

import java.util.Scanner;

public class Q6 {
    public String q6(String str){
        String answer ="";
        for(int i=0; i<str.length(); i++){
            if(str.indexOf(str.charAt(i))==i){
                answer += str.charAt(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Q6 q6 = new Q6();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q6.q6(str));
    }
}
