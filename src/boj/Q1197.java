package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1197 {
    private static int n, m;
    private static int[] root;
    private static PriorityQueue<KruscalNode> pq = new PriorityQueue<>();
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        root = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            root[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int inputStart = Integer.parseInt(st.nextToken());
            int inputEnd = Integer.parseInt(st.nextToken());
            int inputCost = Integer.parseInt(st.nextToken());

            pq.add(new KruscalNode(inputStart, inputEnd, inputCost));
        }

        for (int i = 0; i < m; i++) {
            KruscalNode current = pq.poll();

            int isLandA = find(current.start);
            int isLandB = find(current.end);

            if (isLandA == isLandB) {
                continue;
            }

            union(isLandA, isLandB);
            result += current.cost;
        }

        System.out.println(result);
    }

    private static int find(int isLand) {
        if (isLand == root[isLand]) {
            return isLand;
        }
        root[isLand] = find(root[isLand]);
        return root[isLand];
    }

    private static void union(int isLandA, int isLandB) {
        int isLandARoot = find(isLandA);
        int isLandBRoot = find(isLandB);

        if (isLandARoot != isLandBRoot) {
            root[isLandARoot] = isLandBRoot;
        } else {
            return;
        }
    }
}

class KruscalNode implements Comparable<KruscalNode> {
    int start;
    int end;
    int cost;

    KruscalNode(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(KruscalNode o) {
        return Integer.compare(cost,o.cost);
    }
}
