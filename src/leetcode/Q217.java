package leetcode;

import java.util.Arrays;

public class Q217 {
    public static void main(String[] args) {
        int[] nums = {3,1};

        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 1){
            return false;
        }

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
