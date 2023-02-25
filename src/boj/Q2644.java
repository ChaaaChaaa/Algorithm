package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2644 {
    static int ans = -1;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        dfs(visited, a, b, 0);
        System.out.println(ans + "\n");
    }

    public static void dfs(boolean[] visited, int start, int target, int cnt) {
        if(start == target){
            ans = cnt;
            return;
        }

        visited[start] = true;

        for(int person = 0; person<list.get(start).size(); person++){
            int next = list.get(start).get(person);
            if(!visited[next]){
                dfs(visited,next,target,cnt+1);
            }
        }
    }
}

