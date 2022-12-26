package leetcode;

public class Q104_Recursion {

    public int maxDepth(TreeNode root) {
        return calMaxDepth(root);
    }

    private int calMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = calMaxDepth(root.left);
        int right = calMaxDepth(root.right);

        return Math.max(right, left) + 1;
    }
}
