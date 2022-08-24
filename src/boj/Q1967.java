package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1967 {
    private static int[] distance;
    private static int nodeCount;
    private static List<List<EdgeInfo>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        StringTokenizer st;
        nodeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i <= nodeCount; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(v1).add(new EdgeInfo(v2, cost));
            list.get(v2).add(new EdgeInfo(v1, cost));
        }

        int longetLengthIndex = bfs(1);
        int ansIndex = bfs(longetLengthIndex);

        System.out.println(distance[ansIndex]);
    }

    private static int bfs(int start) {
        int max = 0;
        distance = new int[nodeCount + 1];
        Queue<EdgeInfo> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodeCount + 1];
        queue.offer(new EdgeInfo(start, 0));

        while (!queue.isEmpty()) {
            EdgeInfo current = queue.poll();

            if (visited[current.node]) {
                continue;
            }

            visited[current.node] = true;

            for (EdgeInfo next : list.get(current.node)) {
                if (!visited[next.node]) {
                    queue.offer(next);
                    distance[next.node] = distance[current.node] + next.cost;
                    max = Math.max(max, distance[next.node]);
                    System.out.println(max);
                }
            }
        }

        int maxIndex = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if (distance[i] == max) {
                maxIndex = i;
                break;
            }
        }
        return maxIndex;
    }
}
