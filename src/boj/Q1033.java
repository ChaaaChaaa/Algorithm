package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Q1033 {
    static List<List<Cocktail>> list;
    static long lcm;
    static boolean[] visited;
    static long[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList<>();
        lcm = 1;
        visited = new boolean[n];
        map = new long[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Cocktail>());
        }


        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            list.get(a).add(new Cocktail(b, p, q));
            list.get(b).add(new Cocktail(a, p, q));

            long max = Math.max(p, q);
            long min = Math.max(p, q);

            lcm *= p * q / gcd(max, min);
        }

        map[0] = lcm;
        dfs(0);
        long gcd = map[0];

        for (int i = 1; i < n; i++) {
            long max = Math.max(gcd, map[i]);
            long min = Math.min(gcd, map[i]);
            gcd = gcd(max, min);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(map[i] / gcd + " ");
        }
        System.out.println(sb);
    }

    public static void dfs(int num) {
        visited[num] = true;
        List<Cocktail> tempList = list.get(num);
        for (Cocktail cocktail : tempList) {
            if (!visited[cocktail.b]) {
                map[cocktail.b] = map[num] * cocktail.p / cocktail.q;
                dfs(cocktail.b);
            }
        }
    }

    public static long gcd(long max, long min) {
        if (min == 0) {
            return max;
        } else {
            return gcd(min, max % min);
        }
    }
}


class Cocktail {
    int b;
    int q;
    int p;

    public Cocktail(int b, int q, int p) {
        this.b = b;
        this.q = q;
        this.p = p;
    }
}