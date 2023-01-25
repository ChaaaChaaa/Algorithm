package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Q1167 {
    private static List<List<Edge>> graph;
    static int distance[], max, index;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        distance = new int[n+1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            while(child != -1){
                int weight = Integer.parseInt(st.nextToken());
                graph.get(parent).add(new Edge(child,weight));
                graph.get(child).add(new Edge(parent,weight));
                child = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,0);
        visited = new boolean[n+1];
        distance = new int[n+1];
        dfs(index,0);
        System.out.println(max);
    }

    public static void dfs(int node, int weight) {
        distance[node] = weight;
        visited[node] = true;

        if (weight > max) {
            max = weight;
            index = node;
        }

        for (Edge edge : graph.get(node)) {
            if (!visited[edge.number]) {
                dfs(edge.number, weight + edge.weight);
            }
        }
    }

}

class Edge {
    int number;
    int weight;

    Edge(int number, int weight) {
        this.weight = weight;
        this.number = number;
    }
}
