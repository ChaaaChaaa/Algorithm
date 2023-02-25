package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {
    static List<List<DijkstraNode>> map;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()) - 1;

        map = new ArrayList<>();
        distance = new int[v];

        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int eachU = Integer.parseInt(st.nextToken()) - 1;
            int eachV = Integer.parseInt(st.nextToken()) - 1;
            int eachW = Integer.parseInt(st.nextToken());

            map.get(eachU).add(new DijkstraNode(eachV, eachW));
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new DijkstraNode(start, 0));

        while (!pq.isEmpty()) {
            DijkstraNode now = pq.poll();

            int length = map.get(now.vertex).size();
            for (int i = 0; i < length; i++) {
                DijkstraNode next = map.get(now.vertex).get(i);

                if (distance[next.vertex] > now.weight + next.weight) {
                    distance[next.vertex] = now.weight + next.weight;
                    pq.add(new DijkstraNode(next.vertex,distance[next.vertex]));
                }
            }
        }
    }
}

class DijkstraNode implements Comparable<DijkstraNode> {
    int vertex;
    int weight;

    public DijkstraNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(DijkstraNode o) {
        return this.weight - o.weight;
    }
}
