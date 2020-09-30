package leetcode;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Q897 {
    public TreeNode increasingBST(TreeNode root){
        TreeNode head = null,pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(head == null){
                head = cur;
            }
            cur.left = null;
            if(pre != null){
                pre.right = cur;
            }
            pre =cur;
            cur = cur.right;
        }
        return head;
    }
   public static void main(String[] args) {

    }
}
