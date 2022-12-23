package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q43 {
    public String q43(String need, String plan) {
        String ans = "Yes";
        Queue<Character> queue = new LinkedList<>();
        for (char x : need.toCharArray()) {
            queue.offer(x);
        }
        for (char x : plan.toCharArray()) {
            if (queue.contains(x)) {
                if (x != queue.poll()) {   //need에 있는걸 꺼냈는데 순서대로가 아니면면
                   return "No";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "No";
        }

        return ans;
    }

    public static void main(String[] args){
        Q43 q43 = new Q43();
        Scanner sc = new Scanner(System.in);
        String need = sc.next();
        String plan = sc.next();
        System.out.println(q43.q43(need,plan));
    }
}
