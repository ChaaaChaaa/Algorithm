package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16928 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] dist = new int[101];
        int [] next = new int[101]; //x에 도착한 이후에 가야할 곳
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=1; i<=100; i++){
            next[i] = i;
            dist[i] = -1; //거리 -1로 초기화
        }

        for(int k=0; k<n+m; k++){
            int x = sc.nextInt(); //사다리
            int y = sc.nextInt(); //뱀
            next[x] = y;//뱀
        }

        dist[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()){
            int x = queue.remove();
            for(int i=1; i<=6; i++){
                int y = x+i;
                if(y>100){
                    continue;
                }
                y = next[y]; //다음칸
                if(dist[y] == -1){ // 방문하지 않았으면
                    dist[y] = dist[x] +1; //거리 구한다
                    queue.add(y);
                }
            }
        }
        System.out.println(dist[100]);
    }
}
