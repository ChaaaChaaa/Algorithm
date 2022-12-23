package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            System.out.println(list);
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {

                tempList.add(nums[i]);
                System.out.println("i : " + i + " start: " + start + " temp : " + tempList);
                backTrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
            System.out.println();
            System.out.println();
        }
    }
}
