package algorithminfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    private static int n;
    private static int e;

    public static void main(String[] args) {
        n = 7;
        e = 9;

        int [] indegree = new int[n+1];
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for(int i=0; i<n+1; i++){
            array.add(new ArrayList<>());
        }

        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        for(int i=0; i<e; i++){
            int c1 = v1[i];
            int c2 = v2[i];

            array.get(c1).add(c2);
            indegree[c2]++;
        }

        topologicalSort(indegree,array);
    }

    private static void topologicalSort(int[] indegree, List<List<Integer>> array){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i=1; i<n+1; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            result.offer(node);

            for(Integer i : array.get(node)){
                indegree[i]--;

                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }
        }

        System.out.println(result);
    }
}
