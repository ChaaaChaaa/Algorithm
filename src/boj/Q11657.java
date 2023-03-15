package boj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q11657 {
    static List<TimeMachine> busMap;
    static int[] distance;
    static int cityNum;
    static int busNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cityNum = sc.nextInt();
        busNum = sc.nextInt();

        distance = new int[cityNum + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < busNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            busMap.add(new TimeMachine(a, b, w));
        }

        if (bellmanFord(1)) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= cityNum; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    private static boolean bellmanFord(int start) {
        boolean cycle = false;
        distance[start] = 0;

        for (int i = 0; i <= cityNum; i++) {
            for (int j = 0; j <= busNum; j++) {
                int busStart = busMap.get(j).start;
                int busArrive = busMap.get(j).arrive;
                int busWeight = busMap.get(j).weight;

                if (distance[busStart] != Integer.MAX_VALUE && distance[busArrive] > distance[start] + busWeight) {
                    distance[busArrive] = distance[busStart] + busWeight;
                    if (i == cityNum) {
                        cycle = true;
                    }
                }
            }
        }
        return cycle;

    }
}

class TimeMachine {
    int start;
    int arrive;
    int weight;

    public TimeMachine(int start, int arrive, int weight) {
        this.start = start;
        this.arrive = arrive;
        this.weight = weight;
    }
}
