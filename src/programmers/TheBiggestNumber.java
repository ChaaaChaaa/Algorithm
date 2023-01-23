package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {
    public String solution(int[] numbers) {
        String ans = "";
        String [] arr = new String[numbers.length];

        for(int i=0; i<arr.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arr[0].equals("0")){
            return "0";
        }

        for(String s:arr){
            ans+=s;
        }
        return ans;
    }
}
