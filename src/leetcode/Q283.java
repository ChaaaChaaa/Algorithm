package leetcode;

import java.util.Arrays;

public class Q283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }

    public static int[] moveZeroes(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            nums[index] = num;
            index++;
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
