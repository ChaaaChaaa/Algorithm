package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr  = br.readLine().split("");

        int zero = 0;
        int one = 0;

        if(arr[0].equals("0")){
            zero++;
        }
        else{
            one++;
        }

        for(int i=1; i<arr.length; i++){
            if(!arr[i-1].equals(arr[i])){
                if(arr[i].equals("0")){
                    zero++;
                }
                else {
                    one++;
                }
            }
        }

        int result = Math.min(zero,one);
        System.out.println(result);
    }
}
