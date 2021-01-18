package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1339 {
    private static int n;
    private static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        alpha = new int[26];
        for(int i=0; i<n; i++){
            String s= br.readLine();
            for(int j=0; j<s.length(); j++){
                alpha[s.charAt(j)-'A'] += Math.pow(10,s.length()-j-1);
            }
        }

        Arrays.sort(alpha);

        int sum =0;
        int t =9;

        for(int i=25; i>=0; i--){
            if(alpha[i] != 0){
                sum += alpha[i] * t--;
            }
        }
        System.out.println(sum);
    }
}
