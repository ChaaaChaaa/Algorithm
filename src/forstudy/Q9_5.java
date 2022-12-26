package forstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Q9_5 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;
    public void solution(int v){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(v,0));
        distance[v] = 0;
        while (!priorityQueue.isEmpty()){
            Edge temp = priorityQueue.poll();
            int now = temp.vex;
            int nowCost = temp.cost;
            if(nowCost>distance[now]){
                continue;
            }
            for(Edge edge : graph.get(now)){
                distance[edge.vex] = nowCost+edge.cost;
                priorityQueue.offer(new Edge(edge.vex,nowCost+edge.cost));
            }
        }
    }

    public static void main(String[] args) {
        Q9_5 q9_5 = new Q9_5();
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        q9_5.solution(1);
        for(int i=2; i<=n; i++){
            if(distance[i] != Integer.MAX_VALUE){
                System.out.println(i+" : "+distance[i]);
            }else{
                System.out.println(i+" : impossible");
            }
        }
    }
}
