package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Q169 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, ++value);

            if (map.get(num) > nums.length / 2) {
                result = num;
            }
        }
        return result;
    }
}
