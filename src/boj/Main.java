package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static List<List<NodeTest>> map;
    static int [] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt()-1;

        map = new ArrayList<>();
        distance = new int[v];

        for(int i=0; i<v; i++){
            map.add(new ArrayList<>());
            distance[i]= Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++){
            int eachU = sc.nextInt()-1;
            int eachV = sc.nextInt()-1;
            int eachW = sc.nextInt();

            map.get(eachU).add(new NodeTest(eachV,eachW));
        }

        d(k);

        for(int i=0; i< v; i++){
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
    }

    private static void d(int start){
        PriorityQueue<NodeTest> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.offer(new NodeTest(start,0));

        while (!queue.isEmpty()){
            NodeTest now = queue.poll();

            for(NodeTest next : map.get(now.vertex)){
                if(distance[next.vertex] > now.weight+ next.weight){
                    distance[next.vertex] = now.weight+ next.weight;
                    queue.add(new NodeTest(next.vertex, distance[next.vertex]));
                }
            }
        }
    }
}

class NodeTest implements Comparable<NodeTest>{
    int vertex;
    int weight;

    public NodeTest(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(NodeTest o) {
        return this.weight - o.weight;
    }
}