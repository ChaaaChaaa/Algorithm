package leetcode;

import java.util.Arrays;

public class Q1470 {
    public static void main(String[] args){
        int[] nums = {2,5,1,3,4,7};
        int n = 3;

        System.out.println(Arrays.toString(shuffle(nums,n)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int [] array = new int[nums.length];

        int j=0;
        int k = 1;

        for(int i=0; i<n; i++){
            array[j] = nums[i];
            j+=2;
            array[k] = nums[i+n];
            k+=2;
        }
        return array;
    }
}
