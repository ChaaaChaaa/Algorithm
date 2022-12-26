package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countNum = Integer.parseInt(br.readLine());
        int[] quickArr = new int[countNum];
        int size = quickArr.length;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<countNum; i++){
            quickArr[i] = Integer.parseInt(st.nextToken());
        }

        SumOfStreet sumOfStreet = new SumOfStreet();
        long result = sumOfStreet.sumOfStreet(quickArr,size);
        System.out.println(result);

    }
}

class SumOfStreet{

   long sumOfStreet(int[] quickArr, int size){
        long result = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
              result += Math.abs(quickArr[i]-quickArr[j]);
            }
        }
        return result;
    }
}
