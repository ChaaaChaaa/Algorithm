package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q448 {
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set set = new TreeSet();
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}
