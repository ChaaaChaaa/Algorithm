package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Q41 {
    public int q41(String str){
        int ans=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            }else{
                stack.pop(); // ) pop
                if(str.charAt(i-1) == '('){ //레이저 바로 앞 지점이 (일때 레이저를 쏜 앞에 막대기들이 있다라는 뜻 : 레이저 앞쪽에서 막대기가 시작됨(토막냄)
                    ans += stack.size(); //stack있는 막대 갯수를 누적해줘야함
                }
                else{
                    ans++; //막대기의 끝
                }
            }
            return ans;
        }

        return ans;
    }
    public static void main(String[] args){
        Q41 q41 = new Q41();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q41.q41(str));
    }
}
