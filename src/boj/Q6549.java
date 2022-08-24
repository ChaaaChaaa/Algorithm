package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6549{
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line[];
        int i, n, arr[];
        StringBuilder res = new StringBuilder();

        while((line = in.readLine().split(" ")).length>1) {
            arr = new int[n = Integer.parseInt(line[0])];
            for(i=1;i<=n;i++) arr[i-1] = Integer.parseInt(line[i]);


        }

    }
}
