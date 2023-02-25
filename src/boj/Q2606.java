package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2606 {
    static List<List<Integer>> computers;
    static boolean [] visited;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        computers = new ArrayList<>();

        for(int i=0; i<=n; i++){
            computers.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            computers.get(a).add(b);
            computers.get(b).add(a);
        }

        cnt = 0;
        int result = dfs(1,visited);
        System.out.println(result);
    }

    public static int dfs(int start, boolean[]visited){
        visited[start] = true;

        for(int i=0; i<computers.get(start).size(); i++){
            int next = computers.get(start).get(i);

            if(!visited[next]){
                dfs(next,visited);
                cnt++;
            }
        }
        return cnt;
    }
}
