package inflearn;

import java.util.Scanner;

public class Q7 {
    public String q7(String str){
        String answer ="YES";
//        str= str.toUpperCase();
//        int length = str.length();
//        for(int i=0; i<length/2; i++){
//            if(str.charAt(i) != str.charAt(length-i-1)){
//                return "NO";
//            }
//        }
//        return answer;
        String temp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(temp)){
            return answer;
        }
        return "NO";
    }
    public static void main(String[] args) {
        Q7 q7 = new Q7();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q7.q7(str));
    }
}
