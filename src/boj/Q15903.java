package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q15903 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int countCard = Integer.parseInt(st.nextToken());
        int countSum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countCard; i++) {
            long card = Long.parseLong(st.nextToken());
            pq.add(card);
        }

        long ans = 0;

        for (int j = 0; j < countSum; j++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}
