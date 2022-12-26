package boj;

import java.util.*;
import java.io.*;

public class Q1963 {

    private static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        prime = new boolean[10000];
        for (int i = 2; i * i < 10000; i++)
            if (!prime[i])
                for (int j = i * i; j < 10000; j += i)
                    prime[j] = true;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            int count = bfs(start, destination);
            bw.write(((count == -1) ? "Impossible" : count) + "\n");
        }

        bw.close();
    }

    private static int bfs(int start, int destination) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[10000];

        q.add(start);
        visited[start] = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == destination)
                return visited[current];

            int next = current;
            int[] digit = new int[4];
            for (int i = 0; i < 4; i++) {
                digit[i] = next % 10;
                next /= 10;
            }

            for (int i = 0, d = 1; i < 4; i++, d *= 10) {
                for (int j = 0; j <= 9; j++) {
                    next = current - (d * digit[i]) + (d * j);
                    if (next < 1000 || prime[next] || next == current || visited[next] != 0)
                        continue;

                    q.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
        return -1;
    }
}