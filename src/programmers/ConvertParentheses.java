package programmers;

import java.util.Stack;

public class ConvertParentheses {
    int position;

    boolean isCorrect(String str){
        boolean ret = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if (str.charAt(i) == '(') {
                left++;
                stack.push('(');
            }
            else { // 아니면 )이므로 right++임
                right++;
                if(stack.isEmpty()){ //짝이 안맞아서
                    ret = false;
                }
                else { //) 일때 pop
                    stack.pop();
                }
            }

            if(left == right){ //가장짧은 규형이 잡힌 문자열을 구해야함
                position = i+1; // u와 v를 구분
                return ret;
            }
        }
        return true;
    }

    public String solution(String p){
        if(p.isEmpty()){
            return p;
        }
        boolean correct = isCorrect(p);

        String u = p.substring(0,position);
        String v = p.substring(position);

        if(correct){
            return u+solution(v);
        }

        String answer = "("+solution(v)+")";

        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i) == '('){
                answer += ")";
            }
            else {
                answer += "(";
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String p = "()))((()";
        ConvertParentheses convertParentheses = new ConvertParentheses();
        System.out.println( convertParentheses.solution(p));
    }
}
