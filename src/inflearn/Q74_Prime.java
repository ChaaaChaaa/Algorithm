package inflearn;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class WonderLandEdge2 implements Comparable<WonderLandEdge2> {

    public int vertex;
    public int cost;

    WonderLandEdge2(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(WonderLandEdge2 o) {
        return this.cost - o.cost;
    }
}

public class Q74_Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<WonderLandEdge2>> graph = new ArrayList<ArrayList<WonderLandEdge2>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<WonderLandEdge2>());
        }
        int[] visit = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new WonderLandEdge2(b, cost));
            graph.get(b).add(new WonderLandEdge2(a, cost)); //무방향이여서 b->a로 갈수도 있음
        }

        int ans = 0;
        PriorityQueue<WonderLandEdge2> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new WonderLandEdge2(1, 0));
        while (!priorityQueue.isEmpty()) {
            WonderLandEdge2 current = priorityQueue.poll();
            int endVertex = current.vertex;
            if (visit[endVertex] == 0) { //정점이 체크가 안되어있을때
                visit[endVertex] = 1;
                ans += current.cost;
                for (WonderLandEdge2 wonderLandEdge2 : graph.get(endVertex)) {
                    if (visit[wonderLandEdge2.vertex] == 0) { //이미갔던 간선들은 안가도록
                        priorityQueue.offer(new WonderLandEdge2(wonderLandEdge2.vertex, wonderLandEdge2.cost));
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
