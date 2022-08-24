package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1516 {
    private static int node;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        cost = new int[node + 1];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < node + 1; i++) {
            list.add(i, new ArrayList<>());
        }

        int[] indegree = new int[node + 1];

        for (int v2 = 1; v2 <= node; v2++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[v2] = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());

            while (v1 != -1) {
                indegree[v2]++;
                list.get(v1).add(v2);
                v1 = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(list);
        System.out.println(cost);

        topologicalSort(list, indegree);
    }

    private static void topologicalSort(List<List<Integer>> list, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[node + 1];

        for (int i = 1; i < node + 1; i++) {
            result[i] = cost[i];
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (Integer nextNode : list.get(currentNode)) {
                indegree[nextNode]--;
                result[nextNode] = Math.max(result[nextNode], cost[nextNode] + result[currentNode]);

                if (indegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        for (int i = 1; i < node + 1; i++) {
            System.out.println(result[i]);
        }
    }
}
