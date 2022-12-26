package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1291 {
    public static void main(String[] args) {
        int low = 100;
        int high = 300;
        System.out.println(sequentialDigits(low,high));
    }
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<9; i++){
            backTrack(result, low, high,0,i);
        }
        Collections.sort(result);
        return result;
    }

    private static void backTrack(List<Integer> result, int low, int high, int value, int i){
        if(value > high){
            return;
        }
        if(value >= low){
            result.add(value);
        }

        if(i>9){
            return;
        }
        backTrack(result,low,high,value*10+i,i+1);
    }
}
