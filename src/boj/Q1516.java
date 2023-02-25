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
    static int n;
    static List<List<Integer>> map = new ArrayList<>();
    static int[] time;
    static int[] parentNum;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n + 1];
        parentNum = new int[n + 1];
        ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int buildingIndex = 1; buildingIndex <= n; buildingIndex++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[buildingIndex] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int parent = Integer.parseInt(st.nextToken());
                if (parent == -1) {
                    break;
                }
                map.get(parent).add(buildingIndex);
                parentNum[buildingIndex]++; // 노드가 다른 노드에 연결되었다는 것을 확인하기 위해 해당 배열의 값을 1 증가시킴
            }
        }

        topologicalSort();

        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (parentNum[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ans[vertex] += time[vertex];
            int size = map.get(vertex).size();

            for (int i = 0; i < size; i++) {
                int next = map.get(vertex).get(i);
                parentNum[next]--;

                if (parentNum[next] == 0) {
                    queue.offer(next);
                }

                ans[next] = Math.max(ans[next], ans[vertex]);
            }
        }
    }
}
