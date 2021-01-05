package leetcode;

import java.util.Stack;

public class Q104_DFS {

    public int maxDepth(TreeNode root) {
      if(root == null){
          return 0;
      }

      Stack<Integer> value = new Stack<>();
      Stack<TreeNode> stack = new Stack<>();

      value.push(1);
      stack.push(root);

      int max = 0;

      while(!stack.isEmpty()){
          TreeNode node = stack.pop();
          int temp = value.pop();

          max = Math.max(max,temp);

          if(node.right != null){
              stack.push(node.right);
              value.push(temp+1);
          }

          if(node.left != null){
              stack.push(node.left);
              value.push(temp+1);
          }
      }
      return max;
    }
}
