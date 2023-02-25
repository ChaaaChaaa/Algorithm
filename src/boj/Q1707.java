package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1707 {
    private static List<List<Integer>> graph;
    private static int[] colors;
    private static final int RED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            colors = new int[v+1];

            for(int vertex=0; vertex<=v; vertex++){
                graph.add(new ArrayList<>());
            }

            for(int edge=0; edge<e; edge++){
                st = new StringTokenizer(br.readLine());
                int a =Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean colored = false; //비연결 그래프를 고려하기 위해 모든 정점을 확인해야 함

            for(int vertex=1; vertex<=v; vertex++){
                if(colors[vertex] == 0) {
                    colored = bfs(vertex, RED);
                }

                if(!colored){
                    break;
                }
            }

            if(colored){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int start, int color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        colors[start] = color;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int next:graph.get(now)){
                if(colors[now] == 0){
                    colors[next] = colors[now]*-1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
