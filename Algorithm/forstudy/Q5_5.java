package forstudy;

import java.util.Scanner;
import java.util.Stack;

public class Q5_5 {
    public int solution(String str) {
      int ans = 0;
      Stack<Character> stack = new Stack<>();
      for (int i=0; i<str.length(); i++){
          if(str.charAt(i) == '('){
              stack.push('(');
          }else{
              stack.pop();
              if(str.charAt(i-1) == '('){
                  ans += stack.size();
              }else{
                  ans++;
              }
          }
      }
      return ans;
    }

    public static void main(String[] args) {
        Q5_5 q55 = new Q5_5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q55.solution(str));
    }
}
