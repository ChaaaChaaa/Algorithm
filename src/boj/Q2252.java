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

        for(int i=0; i<=node; i++){
            list.add(new ArrayList<>()); //방향 그래프를 구성하기 위해 사용
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
        Queue<Integer> queue = new LinkedList<>(); //새로운 노드를 추가하기 위해 사용됩니다(indegree 배열을 사용하여 노드의 입력 개수를 추적합니다).
        Queue<Integer> result = new LinkedList<>(); //위상 정렬된 노드 번호가 담겨 있음

        for(int i=1; i<=node; i++){
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
