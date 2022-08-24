package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12886 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        boolean[][] visited = new boolean[1505][1505];

       // int ans = 0;
        dfs(a,b,c,visited);
        System.out.println(ans);
    }

    public static void dfs(int a, int b, int c, boolean[][] visited){
        if(a==b && b==c){
            ans = 1;
            return ;
        }

//        if(a<b && !visited[a][b]){
//            visited[a][b] = true;
//            visited[b][a] = true;
//            dfs(2*a,b-a,c,visited);
//        }
//
//        if(b<a && !visited[b][a]){
//            visited[a][b] = true;
//            visited[b][a] = true;
//            dfs(a-b,2*b,c,visited);
//        }

        if(a<c && !visited[a][c]){
            visited[a][b] = true;
            visited[b][a] = true;
            dfs(2*a,b,c-a,visited);
        }

        if(c<b && !visited[c][b]){
            visited[c][b] = true;
            visited[b][c] = true;
            dfs(a,b-c,2*c,visited);
        }

        if(b<c && !visited[b][c]){
            visited[c][b] = true;
            visited[b][c] = true;
            dfs(a,2*b,c-b,visited);
        }
    }
}
