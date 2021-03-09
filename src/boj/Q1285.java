package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1285 {
    private static int n;
    private static int ans = Integer.MAX_VALUE;
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n];

        for(int i=0; i<n; i++){
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                if(row.charAt(j) == 'T'){
                    map[i] |=(1<<j);

                }
            }
        }
        System.out.println("시작");
        ans = backTrack(map, 0,"");
        System.out.println("진짜끝");
        System.out.println(ans);
    }

    private static int backTrack(int[] map, int currentDepth,String flag) {
        if (currentDepth == n) {
            int total = 0;
            for(int i=0; i<n; i++){
                int cnt = 0;
                for(int j=0; j<n; j++){
                    if((map[j] & (1<<i)) != 0){
                        //System.out.println(flag);
                        //System.out.println("map : "+Arrays.toString(map)+" j : "+j+" map[j]: "+map[j]+" , i :"+i);
                        //System.out.println(Arrays.toString(map));
                        ++cnt;
                    }
                }
                //System.out.println(" cnt : "+cnt+" n-cnt :"+(n-cnt)+" total : "+total);
                total += Math.min(cnt,n-cnt);
               // System.out.println("total : "+total);
            }
            System.out.println("끝================================");
            return total;
        }


        System.out.println("A "+Arrays.toString(map)+" currentDepth : "+currentDepth+" flag : "+flag);
        int a = backTrack(map, currentDepth + 1,"가");
        //System.out.println("AA "+Arrays.toString(map)+" currentDepth : "+currentDepth+" flag : "+flag);
        System.out.println();
        map[currentDepth] = ~map[currentDepth];


        System.out.println("B "+Arrays.toString(map)+" currentDepth : "+currentDepth+" flag : "+flag);
        int b = backTrack(map, currentDepth + 1,"나");





        //System.out.println("BB "+Arrays.toString(map)+" currentDepth : "+currentDepth+" flag : "+flag);
        return Math.min(a,b);
    }
}
