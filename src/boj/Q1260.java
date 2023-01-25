package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1260 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        visited = new boolean[n];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }

    public static void dfs(int node){
        if(visited[node]){
            return;
        }
        System.out.print(node+" ");
        visited[node] = true;
        for(int i : graph.get(node)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int tempNode = q.poll();
            System.out.print(tempNode+" ");

            for(int i : graph.get(tempNode)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
