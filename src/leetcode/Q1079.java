package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1079 {
    private static int result;

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        result = 0;
        char[] arr  = tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        dfs(arr, 0, visited);
        return result;
    }

    private static void dfs(char[] arr, int cnt, boolean[] visited) {
        System.out.println(cnt);
        if (cnt == arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("IN : "+ arr[i]+" i : "+i+" currentDepth : "+cnt);
            if (visited[i]) {
                continue;
            }
            if(i - 1 >= 0 && arr[i] == arr[i - 1] && !visited[i - 1])  {
                continue;
            }

            result++;
            visited[i] = true;
            dfs(arr, cnt + 1, visited);

            visited[i] = false;
        }
        System.out.println();
    }
}
