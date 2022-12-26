package leetcode;

public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        else{
            return constructTreeFromArray(nums,0,nums.length-1);
        }
    }

    public TreeNode constructTreeFromArray(int [] nums, int left, int right){
        if(left == right){
            return new TreeNode(nums[left]);
        }

        if(left>right ||  left <0 || right > nums.length-1){
            return null;
        }

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTreeFromArray(nums,left,mid-1);
        root.right = constructTreeFromArray(nums,mid+1,right);
        return root;
    }
}
