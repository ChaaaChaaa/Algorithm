package inflearn;

import java.util.Scanner;

public class Q2 {
    public String q2(String str) {
        String newStr = "";
       for(char c : str.toCharArray()){
           if(c-97 >= 0){
               newStr += Character.toUpperCase(c);
           }else{
               newStr +=  Character.toLowerCase(c);
           }

//           if(Character.isLowerCase(c)){
//
//           }
       }
       return newStr;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q2.q2(str));
    }

}
