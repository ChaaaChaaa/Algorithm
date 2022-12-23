package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class WonderLandEdge implements Comparable<WonderLandEdge> {
    public int vertex1;
    public int vertex2;
    public int cost;

    WonderLandEdge(int vertex1, int vertex2, int cost) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.cost = cost;
    }

    @Override
    public int compareTo(WonderLandEdge o) {
        return 0;
    }
}

public class Q74_UnionFind {
    static int[] unionFind;

    public static int Find(int vertex) {
        if (vertex == unionFind[vertex]) {
            return vertex;
        } else {
            return unionFind[vertex] = Find(unionFind[vertex]);
        }
    }

    public static void Union(int a, int b) {
        int findA = Find(a);
        int findB = Find(b);
        if (findA != findB) {
            unionFind[findA] = findB;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //도시 : 정점
        int m = sc.nextInt(); //도로 : 간선
        unionFind = new int[n + 1];
        ArrayList<WonderLandEdge> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            unionFind[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int aCity = sc.nextInt();
            int bCity = sc.nextInt();
            int cost = sc.nextInt();
            arrayList.add(new WonderLandEdge(aCity, bCity, cost));
        }

        int ans = 0;
        //최소비용 누적
        Collections.sort(arrayList); //cost에 의해 간선 정리
        for (WonderLandEdge edge : arrayList) {
            int findVertex1 = Find(edge.vertex1);
            int findVertex2 = Find(edge.vertex2);

            if (findVertex1 != findVertex2) {
                ans += edge.cost;
                Union(edge.vertex1, edge.vertex2);
            }
        }
        System.out.println(ans);
    }
}
