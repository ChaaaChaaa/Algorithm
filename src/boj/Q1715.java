package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//"현재 존재하는 카드 묶음 중에서, 가장 적은 2개의 묶음을 우선적으로 계산"
public class Q1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(); //낮은게 제일 위에있음

        for (int i = 0; i < n; i++) {
            long number = Integer.parseInt(br.readLine());
            pq.add(number);
        }

        long sum = 0;
        while (pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            sum += temp1 + temp2;
            pq.add(temp1 + temp2);
        }
        System.out.println(sum);
    }

}
