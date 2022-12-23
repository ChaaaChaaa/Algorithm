package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2056 {
    private static int node;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        int[] indegree = new int[node + 1];
        cost = new int[node + 1];

        for (int nodeCount = 0; nodeCount <= node; nodeCount++) {
            list.add(nodeCount, new ArrayList<>());
        }

        for (int i = 1; i <= node; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int connetNodes = Integer.parseInt(st.nextToken());

            for (int j = 0; j < connetNodes; j++) {
                int preWork = Integer.parseInt(st.nextToken());
                list.get(preWork).add(i);
                indegree[i] += 1;
            }
        }

        System.out.println(topologicalSort(list, indegree));
    }

    private static int topologicalSort(List<List<Integer>> list, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[node + 1];

        for (int i = 1; i <= node; i++) {
            if (indegree[i] == 0) {
                result[i] = cost[i];
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : list.get(currentNode)) {
                indegree[nextNode]--;
                result[nextNode] = Math.max(result[nextNode], result[currentNode] + cost[nextNode]);

                if (indegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= node; i++) {
            ans = Math.max(ans, result[i]);
        }

        return ans;
    }
}
