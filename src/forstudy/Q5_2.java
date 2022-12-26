package forstudy;

import java.util.Scanner;
import java.util.Stack;

public class Q5_2 {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for(char c : str.toCharArray()){
            if(c =='('){
                while (stack.pop() == ')');
            }else{
                stack.push(c);
            }
        }

        for(int i=0; i<stack.size(); i++){
            ans+= stack.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q5_2 q52 = new Q5_2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q52.solution(str));
    }
}
