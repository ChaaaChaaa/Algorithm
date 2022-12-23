package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1512 {
    public static void main(String[] args) {
        //int [] nums = {1,2,3,1,1,3};
        int [] nums = {1,1,1,1};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            res+= hashMap.getOrDefault(n,0);
            hashMap.put(n,hashMap.getOrDefault(nums,0)+1);

        }
        return res;
    }
}
