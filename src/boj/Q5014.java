package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
    static int[] visited;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int totalStair = Integer.parseInt(st.nextToken());
        int current = Integer.parseInt(st.nextToken());
        int company = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        visited = new int[totalStair + 1];
        ans = -1;

        bfs(totalStair, current, company, up, down);

        if (ans >= 0) {
            System.out.println(ans);
        } else {
            System.out.println("use the stairs");
        }
    }

    private static void bfs(int totalStair, int current, int company, int up, int down) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);
        visited[current] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == company) {
                ans = visited[now] - 1;
                break;
            }

            if (now + up <= totalStair) {
                if (visited[now + up] == 0) {
                    visited[now + up] += visited[now] + 1;
                    queue.add(now + up);
                }
            }
            if (now - down > 0) {
                if (visited[now - down] == 0) {
                    visited[now - down] += visited[now] + 1;
                    queue.add(now - down);
                }
            }
        }
    }
}