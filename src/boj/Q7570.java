package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int [] count = new int[n+1];
        StringTokenizer s=new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int temp =Integer.parseInt(s.nextToken());
            count[temp] = count[temp-1]+1;
            if(count[temp] > max){
                max = count[temp];
            }
        }
        System.out.println(n-max);
    }
}