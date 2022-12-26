//package boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Q9470 {
//    private static int nodeCount,edge;
//    private static int [] cost;
//    private static int [] maxCost;
//    private static List<List<Integer>> river;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int tc = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        while (tc-- > 0){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int inputTC = Integer.parseInt(st.nextToken());
//            nodeCount = Integer.parseInt(st.nextToken());
//            edge = Integer.parseInt(st.nextToken());
//            river = new ArrayList<>();
//            cost = new int[nodeCount+1];
//            int [] indegree = new int[nodeCount+1];
//
//            for(int i=0;i<nodeCount; i++){
//                river.add(new ArrayList<>());
//            }
//
//            while (inputTC-- > 0){
//                st = new StringTokenizer(br.readLine());
//                int v1 = Integer.parseInt(st.nextToken());
//                int v2 = Integer.parseInt(st.nextToken());
//
//                river.get(v1).add(v2);
//                indegree[v2]++;
//            }
//
//            sb.append(inputTC).append(" ").append(topologicalSort(nodeCount,indegree)).append("\n");
//        }
//        System.out.println(sb.toString());
//    }
//
//    private static int topologicalSort(int nodeCount,int [] indegree){
//        Queue<Integer> queue = new LinkedList<>();
//        int [] result = new int[nodeCount];
//
//        for(int i=0; i<=nodeCount; i++){
//            if(indegree[i] == 0){
//                result[i] = cost[i];
//                queue.offer(i);
//            }
//        }
//
//        while (!queue.isEmpty()){
//            int current = queue.poll();
//            for(int next : river.get(current)){
//                indegree[next]--;
//                result[next] = Math.max(result[next],result[current]);
//
//                if(indegree[next] == 0){
//                    queue.offer(next);
//                    int count = 0;
//
//                    for(int j=1; j<= nodeCount; j++){
//                        if(river.get(j).contains(next)){
//                            if(result[j] == result[next]){
//                                count++;
//                            }
//                        }
//                    }
//
//                    if(count>1){
//                        result[next]++;
//                    }
//                }
//            }
//        }
//        return result[nodeCount];
//    }
//}
