package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549_Queue {
    public static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        dist[start] = 0;
        check[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.remove();

            if (now * 2 < MAX) {
                if (check[now * 2] == false) {
                    queue.add(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now];
                }
            }

            if (now + 1 < MAX) {
                if (check[now + 1] == false) {
                    queue.add(now + 1);
                    check[now + 1] = true;
                    dist[now + 1] = dist[now]+1;
                }
            }

            if (now - 1 >= 0) {
                if (check[now - 1] == false) {
                    queue.add(now - 1);
                    check[now - 1] = true;
                    dist[now - 1] = dist[now]+1;
                }
            }
        }
        System.out.println(dist[end]);
    }
}

