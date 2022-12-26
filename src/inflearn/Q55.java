package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q55 {
    int ans = 0;
    int [] distance = {1,-1,5};
    int [] visit;
    Queue<Integer> queue = new LinkedList<>();
    public int q36(int s, int cowPosition){
        visit = new int[10001];
        visit[s] = 1;
        queue.offer(s);
        int level=0;
        while (!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                int x = queue.poll();
                for(int j=0; j<3; j++){
                    int nx = x+distance[j];
                    if(x==cowPosition){
                        return level;
                    }
                    if(nx>=1 && nx<= 10000 && visit[nx]==0){
                        visit[nx] = 1; //방문함
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args){
        Q55 q36 = new Q55();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int cowPosition = sc.nextInt();
        System.out.println(q36.q36(s,cowPosition));
    }
}
