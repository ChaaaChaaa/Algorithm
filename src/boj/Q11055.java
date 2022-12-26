package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11055 {
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] count = new int[n+1];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            count[i] = arr[i];
            for(int j=1; j<i; j++){
                if(arr[j]<arr[i] && count[i] < count[j]+arr[i]){
                    count[i] = count[j]+arr[i];
                }
            }
            if(max<count[i]){
                max = count[i];
            }
        }
        System.out.println(max);
    }
}