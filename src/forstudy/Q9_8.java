package forstudy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge3 implements Comparable<Edge3>{
    public int vertex;
    public int cost;

    public Edge3(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge3 o) {
        return this.cost-o.cost;
    }
}
public class Q9_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Edge3>> graph = new ArrayList<ArrayList<Edge3>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge3>());
        }
        int [] check = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge3(b,c));
            graph.get(b).add(new Edge3(a,c));
        }
        int ans = 0;
        PriorityQueue<Edge3> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge3(1,0));
        while (!priorityQueue.isEmpty()){
            Edge3 temp = priorityQueue.poll();
            int ev = temp.vertex;
            if(check[ev] == 0){
                check[ev] = 1;
                ans += temp.cost;
                for(Edge3 edge3 : graph.get(ev)){
                    if(check[edge3.vertex] == 0){
                        priorityQueue.offer(new Edge3(edge3.vertex,edge3.cost));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
