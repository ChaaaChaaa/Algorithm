package forstudy;

import java.util.Scanner;
import java.util.Stack;

public class Q5_1 {
    public String solution(String str) {
      String ans = "YES";
      Stack<Character> stack = new Stack<>();
      for(char c : str.toCharArray()){
          if(c == ')'){
              stack.push(c);
          }else {
              if(stack.isEmpty()){
                  ans = "NO";
              }
              stack.pop();
          }
      }
      if(!stack.isEmpty()){
          ans = "NO";
      }
      return ans;
    }

    public static void main(String[] args) {
        Q5_1 q51 = new Q5_1();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q51.solution(str));
    }
}
