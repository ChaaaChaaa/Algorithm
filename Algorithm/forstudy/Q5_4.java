package forstudy;

import java.util.Scanner;
import java.util.Stack;

public class Q5_4 {
    public int solution(String str) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int a = stack.pop();
                int b = stack.pop();

                if (c == '+') {
                    stack.push(a + b);
                }
            }
        }
        ans = stack.get(0);
        return ans;
    }


    public static void main(String[] args) {
        Q5_4 q54 = new Q5_4();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q54.solution(str));
    }

}
