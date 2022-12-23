package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q104_BFS {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int count =0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }
}
