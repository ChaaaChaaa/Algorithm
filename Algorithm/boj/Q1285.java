package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1285 {
    private static int ans = Integer.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(map, 0);
        System.out.println(ans);
    }

    private static void dfs(char[][] map, int currentDepth) {
        if (currentDepth == n) {
            int cnt = 0;
            for (char[] row : map) {
                int temp = 0;
                for (char col : row) {
                    if (col == 'T') {
                        temp++;
                    }
                }
                //System.out.println("temp : "+temp+" cnt : "+cnt);
                //print(map);
                cnt = cnt + Math.min(temp, n - temp);
            }
            ans = Math.min(cnt, ans);
            return;
        }
        dfs(map, currentDepth + 1);
        flip(map, currentDepth);
        dfs(map, currentDepth + 1);
    }

    private static void flip(char[][] map, int currentDepth) {
        System.out.println("currentDepth : "+currentDepth);
        for (int i = 0; i < n; i++) {
            if (map[i][currentDepth] == 'H') {
                map[i][currentDepth] = 'T';
            } else {
                map[i][currentDepth] = 'H';
            }
        }
    }

//    private static void print(char [][] map){
//        for(char [] row : map){
//            System.out.println(Arrays.toString(row));
//        }
//    }
}
