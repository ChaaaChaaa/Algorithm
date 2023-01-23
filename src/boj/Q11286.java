package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Abs> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().num);
                }
            } else {
                pq.add(new Abs(num));
            }
        }
    }
}

class Abs implements Comparable<Abs> {
    int num;
    int abs;

    Abs(int num) {
        this.num = num;
        this.abs = Math.abs(num);
    }

    @Override
    public int compareTo(Abs o) {
        if (this.abs == o.abs) {
            return this.num - o.num;
        }

        return this.abs - o.abs;
    }
}
