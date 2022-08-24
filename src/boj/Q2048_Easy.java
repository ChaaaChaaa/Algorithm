package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2048_Easy {
    private static int n;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = 0;
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                index += 1;
            }
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        int[][] tempMap = new int[n + 1][n + 1];
        copy(tempMap, map);

        if (depth == 5) {
            findMaxNumber();
            return;
        }

        for (int i = 0; i < 4; i++) {
            merge(i);
            dfs(depth + 1);
            copy(map, tempMap);
        }
    }

    public static void findMaxNumber() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
    }

    public static void copy(int[][] arr, int[][] arr2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }


    public static void merge(int d) {
        Queue<Integer> queue = new LinkedList();
        int[][] newMap = new int[n + 1][n + 1];

        if (d == 0) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[y][x] != 0) {
                        queue.add(map[y][x]);
                    }
                }
                int index = 0;
                while (!queue.isEmpty()) {
                    int value = queue.peek();
                    if (newMap[index][x] == 0) {
                        newMap[index][x] = queue.poll();
                    } else if (newMap[index][x] == value) {
                        newMap[index][x] += queue.poll();
                        index += 1;
                    } else {
                        index += 1;
                        newMap[index][x] = queue.poll();
                    }
                }
            }
        }

        if (d == 1) {
            for (int x = 0; x < n; x++) {
                for (int y = n - 1; y >= 0; y--) {
                    if (map[y][x] != 0) {
                        queue.add(map[y][x]);
                    }
                }
                int index = n - 1;
                while (!queue.isEmpty()) {
                    int value = queue.peek();
                    if (newMap[index][x] == 0) {
                        newMap[index][x] = queue.poll();
                    } else if (newMap[index][x] == value) {
                        newMap[index][x] += queue.poll();
                        index -= 1;
                    } else {
                        index -= 1;
                        newMap[index][x] = queue.poll();
                    }
                }
            }
        }

        if (d == 2) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] != 0) {
                        queue.add(map[y][x]);
                    }
                }

                int index = 0;
                while (!queue.isEmpty()) {
                    int value = queue.peek();
                    if (newMap[y][index] == 0) {
                        newMap[y][index] = queue.poll();
                    } else if (newMap[y][index] == value) {
                        newMap[y][index] += queue.poll();
                        index += 1;
                    } else {
                        index += 1;
                        newMap[y][index] = queue.poll();
                    }
                }
            }
        }

        if(d == 3){
            for(int y=0; y<n; y++){
                for(int x= n-1; x>= 0; x--){
                    if(map[y][x] != 0){
                        queue.add(map[y][x]);
                    }
                }

                int index = n-1;
                while (!queue.isEmpty()){
                    int value = queue.peek();
                    if(newMap[y][index] == 0){
                        newMap[y][index] = queue.poll();
                    }

                    else if(newMap[y][index] == value){
                        newMap[y][index] += queue.poll();
                        index -= 1;
                    }

                    else {
                        index -= 1;
                        newMap[y][index] = queue.poll();
                    }
                }
            }
        }
        copy(map, newMap);
    }
}
