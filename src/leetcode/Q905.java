package leetcode;


import java.util.LinkedList;
import java.util.List;

public class Q905 {
    public int[] sortArrayByParity(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] %2 == 0){
                System.out.println("i : "+i+" , j :"+j);
                temp(nums);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }

    private void temp(int[] nums) {
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }

        System.out.println(list.toString());
    }

    public static void main(String[] args){
        Q905 q905 = new Q905();
        int [] nums = {3,1,2,4};
        q905.sortArrayByParity(nums);

    }
}
