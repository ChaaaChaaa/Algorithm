package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q5 {
    public String q5(String str){
       String answer;
       char[] chars = str.toCharArray();
       int lt=0, rt=str.length()-1;

       while (lt<rt){
           if(!Character.isAlphabetic(chars[lt])){
               lt++;
           }
           else if(!Character.isAlphabetic(chars[rt])){
               rt--;
           }
           else{
               char temp =chars[lt];
               chars[lt] = chars[rt];
               chars[rt] = temp;
               lt++;
               rt--;
           }
       }
       answer = String.valueOf(chars);
       return answer;
    }
    public static void main(String[] args) {
        Q5 q5 = new Q5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q5.q5(str));
    }
}
