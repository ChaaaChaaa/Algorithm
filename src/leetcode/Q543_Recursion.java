package leetcode;

public class Q543_Recursion {
    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(22);
        node.left.left.right = new TreeNode(90);

        System.out.println(diameterOfBinaryTree(node));
    }

    private static  int max = 0;


    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left+right);
        int result = Math.max(left,right)+1;
        return result;
    }
}
