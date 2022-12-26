package sort;

import java.io.*;
import java.util.Arrays;

public class Q10989 {
    private static final String NEW_LINE = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countNum = Integer.parseInt(br.readLine());
        int sortNum [] = new int [countNum];

        for(int i=0; i<countNum; i++){
            sortNum[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(sortNum);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num : sortNum){
            bw.write(num+NEW_LINE);
        }
        bw.close();
    }
}
