package algorithminfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vertex;
    public int cost;
    Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge edge){
        return this.cost - edge.cost;
    }
}
public class Dijkstra {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;
    public void solution(int v){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(v,0));
        distance[v] = 0;
        while (!priorityQueue.isEmpty()){
            Edge currentEdge = priorityQueue.poll(); //cost비용이 가장 낮은값이 poll되어 나온다.
            int currentVertex = currentEdge.vertex;
            int currentCost = currentEdge.cost;

            if(currentCost > distance[currentVertex]){
                continue;
            }

            for(Edge edge : graph.get(currentVertex)){ //currentVertex와 연결된 간선 정보가 모두 출력 : 그래프 탐색
                if(distance[edge.vertex] > currentCost + edge.cost){ //간선에 연결된 cost가 더 작으면
                    distance[edge.vertex] = currentCost + edge.cost; //값을 바꿔준다.
                    priorityQueue.offer(new Edge(edge.vertex, currentCost+ edge.cost)); // queue에 vertex와 cost를 넣어준다
                }
            }
        }
    }

    public static void main(String[] args){
        Dijkstra dijkstra = new Dijkstra();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점 갯수
        m = sc.nextInt(); //간선 갯수
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int index=sc.nextInt();
            int vertex=sc.nextInt();
            int cost=sc.nextInt();
            graph.get(index).add(new Edge(vertex,cost));
        }

        dijkstra.solution(1);
        for(int i=2; i<=n; i++){
            if(distance[i] != Integer.MAX_VALUE){
                System.out.println(i+" : "+distance[i]);
            }else{
                System.out.println(i+" : impossible");
            }
        }
   }
}
