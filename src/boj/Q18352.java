package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q18352 {

    static int cityNum, loadNum, shortestDistanceCity, start;
    static List<List<City>> map;

    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new ArrayList<>();

        cityNum = Integer.parseInt(st.nextToken());
        loadNum = Integer.parseInt(st.nextToken());
        shortestDistanceCity = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());


        distance = new int[cityNum + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= cityNum; i++) {
            map.add(new ArrayList<>());
        }

        while (loadNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(new City(b, 1));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == shortestDistanceCity) {
                sb.append(i).append('\n');
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    private static void dijkstra(int cityNumber) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[cityNum + 1];

        distance[cityNumber] = 0;
        visited[cityNumber] = true;
        pq.offer(new City(cityNumber, 0));

        while (!pq.isEmpty()) {
            City now = pq.poll();

            visited[now.citNumber] = true;

            for (City city : map.get(now.citNumber)) {
                int nextCity = city.citNumber;
                int nextWeight = city.weight;

                if (!visited[nextCity] && distance[nextCity] > (nextWeight + distance[now.citNumber])) {
                    distance[nextCity] = nextWeight + distance[now.citNumber];
                    pq.offer(new City(nextCity, distance[nextCity]));
                }
            }
        }

    }
}

class City implements Comparable<City> {
    int citNumber;
    int weight;

    public City(int citNumber, int weight) {
        this.citNumber = citNumber;
        this.weight = weight;
    }

    @Override
    public int compareTo(City o) {
        return this.weight - o.weight;
    }
}
