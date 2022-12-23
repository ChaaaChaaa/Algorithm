package leetcode;

public class Q543_Array {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }

    private int maxDepth(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left, diameter);
        int right = maxDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }
}
