package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2252 {
    private static int node, edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int [] indegree = new int[node+1];

        for(int i=0; i<node+1; i++){
            list.add(i, new ArrayList<>());
        }

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());
           int v1 = Integer.parseInt(st.nextToken());
           int v2 = Integer.parseInt(st.nextToken());

           list.get(v1).add(v2);
           indegree[v2]++;
        }

        topologicalSort(list,indegree);
    }

    private static void topologicalSort(List<List<Integer>> list, int [] indegree){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i=1; i<node+1; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            result.offer(currentNode);

            for(Integer nextNode : list.get(currentNode)){
                indegree[nextNode]--;
                if(indegree[nextNode] == 0){
                    queue.offer(nextNode);
                }
            }
        }
        while(!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
    }
}
