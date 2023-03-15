package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Q11403 {
    private static List<List<Integer>> map;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int vertex = sc.nextInt();
                if(vertex == 1){
                    map.get(i).add(j);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                visited = new boolean[n+1];
                if (bfs(i,j)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");;
                }
            }
            System.out.println();
        }

    }

    private static boolean bfs(int start, int arrive) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : map.get(now)) {
                if (next == arrive) {
                    return true;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}
