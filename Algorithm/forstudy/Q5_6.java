package forstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5_6 {
    public int solution(int n, int k) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1){
                ans = queue.poll();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q5_6 q56 = new Q5_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(q56.solution(n, k));
    }
}
