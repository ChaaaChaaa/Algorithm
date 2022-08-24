package algorithminfo;

import java.util.Scanner;

public class 경로탐색_DFS {
    static int n, m, answer;
    static int[][] graph;
    static int[] visit;

    public void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && visit[i] == 0) { //방문안하고 선이 연결되어있는곳
                    visit[i] = 1;
                    dfs(i); //v에서 i로 이동
                    visit[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        경로탐색_DFS dfs = new 경로탐색_DFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visit = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int destination = sc.nextInt();
            graph[start][destination] = 1;
        }
        visit[1] = 1; //1번 node
        dfs.dfs(1);
        System.out.println(answer);
    }
}
