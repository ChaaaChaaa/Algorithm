package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q42 {
    public int q42(int n, int k){
        int ans=0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.offer(i); //1부터 8까지 넣는다. 문제 조건
        }
        while (!queue.isEmpty()){
            for(int i=1; i<k; i++){
                queue.offer(queue.poll());
            }
            queue.poll(); //k를 외친사람이므로 제거한다.
            if(queue.size() == 1){
                ans = queue.poll();
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Q42 q42 = new Q42();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(q42.q42(n,k));
    }
}
