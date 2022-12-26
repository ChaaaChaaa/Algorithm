package algorithminfo;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색_DFS_ArrayList {
    static int n,m,answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visit;
    public void dfs(int v){
        if(v==n){
            answer++;
        }
        else{
            for(int nextVertex :graph.get(v)){
                if(visit[nextVertex] == 0){
                    visit[nextVertex] = 1;
                    dfs(nextVertex);
                    visit[nextVertex] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        경로탐색_DFS_ArrayList dfsArrayList = new 경로탐색_DFS_ArrayList();
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m=sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>()); //객체생성 방법
        }
        visit = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
    }
}
