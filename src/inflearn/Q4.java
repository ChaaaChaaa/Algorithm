package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q4 {
   public ArrayList<String> q4(int num, String[] strs){
       ArrayList<String> arrayList = new ArrayList<>();
//       for(String s:strs){
//           String temp = new StringBuilder(s).reverse().toString();
//           arrayList.add(temp);
//       }

       for(String s : strs){
           char[] chars = s.toCharArray();
           int lt=0, rt=s.length()-1;
           while (lt<rt){
               char temp = chars[lt];
               chars[lt] = chars[rt];
               chars[rt] = temp;
               lt++;
               rt--;
           }
           String temp = String.valueOf(chars);
           arrayList.add(temp);
       }
       return arrayList;
   }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] str = new String[num];
        for(int i=0; i<num; i++){
            str[i]  = sc.next();
        }

        for(String s : q4.q4(num,str)){
            System.out.println(s);
        }

    }
}
