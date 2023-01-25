package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q13023 {
    static List<List<Integer>> list = new ArrayList<>();
    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }


        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }


        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            if(result != 1){
                dfs(i,1);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int index, int cnt) {
        if (cnt == 5) {
            result = 1;
            return;
        }

        visited[index] = true;
        for (int i : list.get(index)) {
           if(!visited[i]){
               dfs(i,cnt+1);
           }
        }
        visited[index] = false;
    }
}
