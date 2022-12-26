package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Q37 {
    public String q37(String str){
        String ans="Yes";
        Stack<Character> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(x=='('){
                stack.push(x);
            }
            else{
                if(stack.isEmpty()){
                    return "No";
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){ //(가 많은 상황
            return "No";
        }
        return ans;
    }
    
    public static void main(String[] args){
        Q37 q37 = new Q37();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q37.q37(str));
    }
}
