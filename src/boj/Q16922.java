package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16922 {
    private final static int[] number = {1, 5, 10, 50};
    private final static int SIZE = 4;
    private static int answer;
    private static int n;
    private static boolean[] visit ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[50*20+1];

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int index, int depth, int sum) {
       if(n == depth){
           if(!visit[sum]){
               visit[sum] = true;
               answer++;
           }
           return;
       }

       for(int i=index; i<SIZE; i++){
           dfs(i,depth+1,sum+number[i]);
       }

    }
}
