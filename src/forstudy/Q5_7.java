package forstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5_7 {
    public String solution(String need, String plan) {
        String ans = "YES";
        Queue<Character> queue = new LinkedList<>();
        for(char needSubject : need.toCharArray()){
            queue.offer(needSubject);
        }

        for(char planSubject : plan.toCharArray()){
            if(queue.contains(planSubject)){
                if(queue.poll() != planSubject){
                    return "NO";
                }
            }
        }

        if(!queue.isEmpty()){
            return "NO";
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q5_7 q57 = new Q5_7();
        String a = sc.next();
        String b = sc.next();
        System.out.println(q57.solution(a, b));
    }
}
