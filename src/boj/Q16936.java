package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16936 {
    private static int [] temp;
    private static boolean flag = false;
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long [] arr = new long[n];
        temp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        for(int i=0; i<n; i++){
            Arrays.fill(temp, -1);
            backTracking(n, arr, i, 0);
            System.out.println("OUT");
        }
    }

    private static void backTracking(int n, long [] arr, int currentDepth, int index){
        System.out.println("n = " + n + ", arr = " + Arrays.toString(arr) + ", currentDepth = " + currentDepth + ", index = " + index);

        if(flag){
            return;
        }

        temp[currentDepth] = index;

        if(index == n-1){
            getResult(n, arr);
            flag = true;
            return;
        }

        for(int next = 0; next <n; next++){
            if(temp[next] != -1){
                continue;
            }
            if((arr[currentDepth] %3 == 0 && arr[currentDepth] /3 == arr[next]) ||
             arr[currentDepth] *2 == arr[next]){
                backTracking(n,arr,next,index+1);
            }
        }
    }

    private static void getResult(int n, long [] arr){
        StringBuilder sb = new StringBuilder();
        int [] result = new int[n];

        for(int i=0; i<n; i++){
            int tempNum = temp[i];
            result[tempNum] = i;
        }


        for(int i=0; i<n; i++){
            int resultNum = result[i];
            sb.append(arr[resultNum]).append(SPACE);
        }

        System.out.println(sb.toString());
    }
}