package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Q40 {
    public int q40(String str){
        int ans=0;
        Stack<Integer> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-48);
                System.out.println(x-48);
            }
            else{
                int rt= stack.pop();
                int lt = stack.pop();
                if(x=='+'){
                    stack.push(lt+rt);
                }
                else if(x=='-'){
                    stack.push(lt-rt);
                }
                else if(x=='*'){
                    stack.push(lt*rt);
                }
                else if(x=='/'){
                    stack.push(lt/rt);
                }
            }
        }
        ans = stack.get(0);
        return ans;
    }

    public static void main(String[] args){
        Q40 q40 = new Q40();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(q40.q40(str));
    }
}
