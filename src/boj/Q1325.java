package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1325 {
    static List<List<Integer>> map;
    static int n;
    static int [] connectedComputers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        map = new ArrayList<>();
        connectedComputers = new int[n+1];
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }

        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map.get(a).add(b);
        }

        for(int i=1; i<=n; i++){
            bfs(i);
        }

        for(int computer : connectedComputers){
            max = Math.max(max,computer);
        }

        for(int i=0; i<connectedComputers.length; i++){
            if(max == connectedComputers[i]){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }

    private static void bfs(int target){
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[n+1];

        queue.add(target);
        visited[target] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int num : map.get(now)){
                if(!visited[num]){
                    visited[num] = true;
                    connectedComputers[num]++;
                    queue.offer(num);
                }
            }
        }
    }
}
