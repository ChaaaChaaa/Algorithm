package fortest;

import java.util.*;

class Edge implements Comparable<Edge> {
    public int money;
    public int time;

    public Edge(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Edge o) {
        return o.time - this.time;
    }
}

class Q4 {
    public static int n,max;
    public static int solution(ArrayList<Edge> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        int ans = 0;
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).time < i) {
                    break;
                } else {
                    pq.offer(list.get(j).money);
                }
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Q4 q9_4 = new Q4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Edge> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arrayList.add(new Edge(m, d));
            if (d > max) {
                max = d;
            }
        }
        System.out.println(q9_4.solution(arrayList));
    }

}
