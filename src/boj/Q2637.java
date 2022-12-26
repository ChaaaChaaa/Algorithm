package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2637 {
    //private static int[][] cost;
    private static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        int tc = Integer.parseInt(br.readLine());
        int[] indegree = new int[nodeCount + 1];
        //cost = new int[nodeCount+1][nodeCount+1];
        //List<List<Integer>> list = new ArrayList<>();
        List<List<EdgeInfo>> list = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            list.add(new ArrayList<>());
            //cost[i][i] = 1;
        }

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v2 = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            //cost[v2][v1] = Integer.parseInt(st.nextToken());
            int edgeCost = Integer.parseInt(st.nextToken());

            list.get(v1).add(new EdgeInfo(v2,edgeCost));
            indegree[v2]++;
        }

        topologicalSort(list, indegree);
    }

    private static void topologicalSort(List<List<EdgeInfo>> list, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int[][] result = new int[nodeCount + 1][nodeCount + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= nodeCount; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[i][i] = 1;
            }
        }

        System.out.println(result);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (EdgeInfo next : list.get(currentNode)) {
                for (int i = 1; i <= nodeCount; i++) {
//                   if(currentNode == i){
//                       continue;
//                   }
                   //cost[next.node][i] += cost[currentNode][i] *next.cost;
                    result[next.node][i] += result[currentNode][i] *next.cost;
                    //System.out.println(result[next.node][i]);
                }

                indegree[next.node]--;
                if (indegree[next.node] == 0) {
                    queue.offer(next.node);
                }
            }
        }

       // System.out.println(result);

        for (int i = 1; i <= nodeCount; i++) {
            if (result[nodeCount][i] != 0) {
                //sb.append(i + " " + cost[nodeCount][i] + "\n");
                sb.append(i + " " + result[nodeCount][i] + "\n");
            }
        }
        System.out.println(sb);
    }
}

class EdgeInfo{
    int node;
    int cost;

    EdgeInfo(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
