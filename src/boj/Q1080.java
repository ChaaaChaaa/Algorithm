package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arrA = new int[n][m];
        int[][] arrB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arrA[i][j] = row.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arrB[i][j] = row.charAt(j)-'0';
            }
        }

        int cnt = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                System.out.println(i+","+j);
                if (arrA[i][j] != arrB[i][j]) {
                    //printMap(arrA);
                    trans(arrA, i, j);
                    // printMap(arrA);
                    cnt++;
                }
            }
        }

        if (isSame(arrA, arrB)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    public static void trans(int[][] map, int x, int y) {
        if (0 <= x && x <= map.length - 3 && 0 <= y && y <= map[x].length - 3) {
            for (int i = x; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    map[i][j] ^= 1;
                }
            }
        }
    }

    public static boolean isSame(int[][] arrA, int[][] arrB) {
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrA[i].length; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

//    private static void printMap(int[][] map){
//        for(int [] arr : map){
//            System.out.println(Arrays.toString(arr));
//        }
//    }
}