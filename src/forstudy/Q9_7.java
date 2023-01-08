package forstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
    public int v1;
    public int v2;
    public int cost;

    public Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.cost - o.cost;
    }
}

public class Q9_7 {
    static int[] unionFind;

    public static int find(int v) {
        if (v == unionFind[v]) {
            return v;
        } else {
            return unionFind[v] = find(unionFind[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unionFind[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unionFind = new int[n + 1];
        ArrayList<Edge2> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            unionFind[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arrayList.add(new Edge2(a, b, c));
        }

        int ans = 0;
        Collections.sort(arrayList);
        for (Edge2 edge2 : arrayList) {
            int findV1 = find(edge2.v1);
            int findV2 = find(edge2.v2);
            if (findV1 != findV2) {
                ans += edge2.cost;
                union(edge2.v1, edge2.v2);
            }
        }
        System.out.println(ans);
    }
}
