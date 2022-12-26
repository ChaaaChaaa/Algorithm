package algorithminfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프최단거리_BFS {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visit,distance;

    public void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        visit[vertex] = 1;
        distance[vertex] = 0;

        queue.offer(vertex);
        while (!queue.isEmpty()){
            int currentVertex = queue.poll();
            for(int nextVertex : graph.get(currentVertex)){
                if(visit[nextVertex]==0){
                    visit[nextVertex] = 1;
                    queue.offer(nextVertex);
                    distance[nextVertex] = distance[currentVertex]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        그래프최단거리_BFS bfs = new 그래프최단거리_BFS();
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m=sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        visit = new int[n+1];
        distance = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        bfs.bfs(1);
    }
}
