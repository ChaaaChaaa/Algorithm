package inflearn;

import java.util.Stack;

public class Q38 {
    public String q38(String str) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') ; // ) 만나면 )까지 다 pop시킨다. ( 꺼내고 멈춘다.
            } else {
                stack.push(x);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            ans += stack.get(i);
        }
        return ans;
    }
}
