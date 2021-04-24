package leetcode;

public class Q287 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2,};
        //.out.println(findDuplicate(nums));
        findDuplicate(nums);
    }

    public static int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start <= end) {
            int mid = (int) (start + (end - start) * 0.5);
            int target = 0;
            System.out.println("1 start : "+start+" end : "+end+" mid : "+mid);
            for (int a : nums) {
                if (a <= mid) {
                    System.out.println("2 a : "+a+" mid : "+mid+" target : "+target);
                    ++target;
                }
            }
            System.out.println("2-2 mid : "+mid+" end : "+target);
            if (target <= mid) {
                System.out.println("3 start : "+start+" end : "+end+" mid : "+mid);
                start = mid + 1;
            } else {
                System.out.println("4 start : "+start+" end : "+end+" mid : "+mid);
                end = mid - 1;
            }
            System.out.println("5 start : "+start+" end : "+end+" mid : "+mid);
        }
        System.out.println("6 start : "+start+" end : "+end);
        return start;
    }
}
