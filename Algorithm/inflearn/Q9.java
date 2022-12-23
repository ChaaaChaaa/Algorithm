package inflearn;

import java.util.Scanner;

public class Q9 {
    public int q9(String str) {
//        int answer = 0;
//        for(char x : str.toCharArray()){
//            if(x>=48&&x<=57){
//                answer = answer*10+(x-48);
//            }
//        }
//        return answer;
        String answer="";
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)){ //숫자냐
                answer+=x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Q9 q9 = new Q9();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q9.q9(str));
    }

}
