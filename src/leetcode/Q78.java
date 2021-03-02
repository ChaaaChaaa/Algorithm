package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            System.out.println("i : "+i+" nums[i] : "+nums[i]+" tempList :" +tempList);
            //System.out.println(nums[i]);
            //System.out.println("A : tempList: "+ tempList+" , start: "+start + " i : "+i+" i < nums.length : "+nums.length);
            tempList.add(nums[i]);
            System.out.println(tempList);
            backtrack(list, tempList, nums, i + 1);
            //System.out.println("remove : "+tempList.get(tempList.size() - 1));
            tempList.remove(tempList.size() - 1);
        }
        System.out.println();
    }

}
