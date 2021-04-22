package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1005 {
    private static int node,edge;
    private static int [] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());

            cost = new int[node+1];

            int [] indegree = new int[node+1];

            List<List<Integer>> list = new LinkedList<>();
            for(int i=0; i<node+1; i++){
                list.add(i,new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<node+1; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<edge; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                indegree[v2]++;
            }

            int w = Integer.parseInt(br.readLine());
            topologicalSort(list,w,indegree);
        }
    }

    private static void topologicalSort(List<List<Integer>> list, int w, int [] indegree){
        Queue<Integer> queue = new LinkedList<>();
        int [] result = new int[node+1];

        for(int i=1; i<=node; i++){
            result[i] = cost[i];
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int currentNode = queue.poll();

            for(Integer nextNode : list.get(currentNode)){
                int totalBuildTime = result[currentNode]+cost[nextNode];
                result[nextNode] = Math.max(result[nextNode], totalBuildTime);

                indegree[nextNode]--;

                if(indegree[nextNode] == 0){
                    queue.offer(nextNode);
                }
            }
        }

        System.out.println(result[w]);
    }
}
