package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q543_Stack {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        Map<TreeNode,Integer> map = new HashMap<>();

        stack1.push(root);
        int max = 0;

        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);

            if(node.left != null){
                stack1.push(node.left);
            }

            if(node.right != null){
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            int left = 0;
            int right = 0;
            if(node.left != null){
                left = map.getOrDefault(node.left,0);
            }
            if(node.right != null){
                right = map.getOrDefault(node.right,0);
            }
            max = Math.max(max,left+right);
            map.put(node,Math.max(left,right)+1);
        }
        return max;
    }
}
