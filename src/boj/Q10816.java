package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
    private static final int NOT_EXIST = 0;
    private static final char BLANK = ' ';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());


        StringTokenizer token = new StringTokenizer(bufferedReader.readLine());
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int firstTemp = Integer.parseInt(token.nextToken());
            if(hashMap.containsKey(firstTemp)){
                hashMap.put(firstTemp,hashMap.get(firstTemp)+1);
            }
            else{
                hashMap.put(firstTemp,1);
            }
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        token = new StringTokenizer(bufferedReader.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
           int secondTemp = Integer.parseInt(token.nextToken());
           if(hashMap.containsKey(secondTemp)){
                sb.append(hashMap.get(secondTemp)).append(BLANK);
           }
           else{
               sb.append(NOT_EXIST).append(BLANK);
           }
        }
        System.out.println(sb);
    }
}
