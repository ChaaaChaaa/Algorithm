package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1916 {
    static List<List<Bus>> busMap;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityNum = sc.nextInt();
        int busNum = sc.nextInt();

        busMap = new ArrayList<>();
        distance = new int[cityNum + 1];
        visited = new boolean[cityNum + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= cityNum; i++) {
            busMap.add(new ArrayList<>());
        }

        for (int i = 0; i < busNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();

            busMap.get(a).add(new Bus(b, weight));
        }

        int start = sc.nextInt();
        int arrive = sc.nextInt();
        d(start, arrive);
        System.out.println(distance[arrive]);
    }

    private static void d(int start, int arrive) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Bus now = pq.poll();

            if(!visited[now.vertex]){
                visited[now.vertex] = true;

                for (Bus next : busMap.get(now.vertex)) {
                    if (distance[next.vertex] > next.weight + distance[now.vertex]) {
                        distance[next.vertex] = next.weight + distance[now.vertex];
                        pq.offer(new Bus(next.vertex, distance[next.vertex]));
                    }
                }
            }
        }
    }
}

class Bus implements Comparable<Bus> {
    int vertex;
    int weight;

    public Bus(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }


    @Override
    public int compareTo(Bus o) {
        return this.weight - o.weight;
    }
}
