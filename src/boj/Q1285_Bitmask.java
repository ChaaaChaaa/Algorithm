package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1285_Bitmask {
    private static int n;
    private static int ans = Integer.MAX_VALUE;
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                if (row.charAt(j) == 'T') {
                    map[i] |= (1 << j);
                }
            }
        }
        ans = backTrack(map, 0);
        System.out.println(ans);
    }

    private static int backTrack(int[] map, int currentDepth) {
        if (currentDepth == n) {
            int total = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if ((map[j] & (1 << i)) != 0) {
                        ++cnt;
                    }
                }
                total += Math.min(cnt, n - cnt);
            }
            return total;
        }

        int a = backTrack(map, currentDepth + 1);
        map[currentDepth] = ~map[currentDepth];
        int b = backTrack(map, currentDepth + 1);
        return Math.min(a, b);
    }

    private static void print() {
        System.out.println(map[0] + " : " + Integer.toBinaryString(map[0]));
        System.out.println(map[1] + " : " + Integer.toBinaryString(map[1]));
        System.out.println(map[2] + " : " + Integer.toBinaryString(map[2]));
    }
}
