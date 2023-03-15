package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q11725 {
    private static List<List<Integer>> map;
    private static boolean [] visited;
    private static int [] parentNode;// 부모 노드 저장 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new ArrayList<>();
        visited = new boolean[n];
        parentNode = new int[n];

        for(int i=0; i<n; i++){
            map.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            map.get(a).add(b);
            map.get(b).add(a);
        }

        bfs(0);

        for(int i=1; i<n; i++){
            System.out.println(parentNode[i]+1);
        }
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int next : map.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    parentNode[next] = now;
                }
            }
        }


    }
}
