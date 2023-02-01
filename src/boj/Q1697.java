package boj;

import java.util.*;

class Q1697{
    static int [] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new int[100001];

        if(n==m){
            System.out.println(0);
            return;
        }
        bfs(n,m);
        System.out.println(visited[m]);
    }

    private static void bfs(int subin, int sister){
        Queue<Integer> q = new LinkedList<>();
        visited[subin] = 0;
        q.add(subin);

        while(!q.isEmpty()){
            int p = q.poll();

            if(p-1 >=0 && visited[p-1]== 0){
                q.offer(p-1);
                visited[p-1] = visited[p]+1;
            }
            if(p+1 < visited.length && visited[p+1] == 0){
                q.offer(p+1);
                visited[p+1] = visited[p]+1;
            }
            if(p*2 < visited.length && visited[2*p] == 0){
                q.offer(p*2);
                visited[p*2] = visited[p]+1;
            }
        }
    }
}