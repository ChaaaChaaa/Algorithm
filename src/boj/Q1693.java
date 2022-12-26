//package boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Q1693 {
//    private static final int MAX = 100001;
//    private static final int COLOR = 19;
//
//    private static List<List<Integer>> tree = new ArrayList<>();
//    private static int [][] cache = new int[MAX][COLOR];
//    private static boolean [] visited = new boolean[MAX];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int nodeCount = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<=nodeCount; i++){
//            tree.add(new ArrayList<>());
//        }
//
//        for(int i=0; i<nodeCount-1; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int v1 = Integer.parseInt(st.nextToken());
//            int v2 = Integer.parseInt(st.nextToken());
//
//            tree.get(v1).add(v2);
//            tree.get(v2).add(v1);
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for(int i=1; i<COLOR; i++){
//            ans = Math.min(ans,dp(1,i));
//        }
//
//        System.out.println(ans);
//    }
//
//    private static int dp(int current, int color){
//        if(cache[current][color] != 0){
//            return cache[current][color];
//        }
//
//        visited[current] = true;
//        cache[current][color] += color;
//        for(int next : tree.get(current)){
//            int min  = Integer.MAX_VALUE;
//
//            if(!visited[next]){
//                for(int i=1; i<COLOR; i++){
//                    if(i != color){
//                        min = Math.min(min,dp(next,i));
//                    }
//                }
//
//                cache[current][color] += min;
//            }
//        }
//        visited[current] = false;
//        return cache[current][color];
//    }
//
//}
