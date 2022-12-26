package inflearn;

import java.util.Scanner;


public class Q73 {
    static int[] unionFind;

    public static int Find(int vertex) { //v=1 -> 1번학생 : 집합번호를 return함
        if (vertex == unionFind[vertex]) {
            return vertex; //
        } else {
            return unionFind[vertex]+Find(unionFind[vertex]);
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
        int n = sc.nextInt();
        int m = sc.nextInt();

        unionFind = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unionFind[i] = i; //초기화
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);
        }
        int aVertex = sc.nextInt();
        int bVertex = sc.nextInt();
        int findA = Find(aVertex);
        int findB = Find(bVertex);

        if (findA == findB) { //값이 같아서 친구관계
            System.out.println("Yes");
        } else { //값이 달라서 친구 아님
            System.out.println("No");
        }
    }
}
