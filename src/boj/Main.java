package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;
    static int n,m,cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            twoPointer(i);
        }

        System.out.println(cnt);
    }

    static void twoPointer(int fixIndex){
        int start=0;
        int end = n-1;
        cnt = 0;

        while(start<end){
            if(start == fixIndex){
                start++;
            }else if(end == fixIndex){
                end--;
            }
            else{
                if(arr[start]+arr[end] == m){
                    cnt++;
                }
                else if(arr[start]+arr[end]>m ){
                    start--;
                }else if(arr[start]+arr[end]<m){
                    end--;
                }
            }
        }
    }
}


