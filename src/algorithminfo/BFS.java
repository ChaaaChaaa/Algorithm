package algorithminfo;

import java.util.LinkedList;
import java.util.Queue;

class BFSNode{
    int data;
    BFSNode lt,rt;
    public BFSNode(int val){
        data = val;
        lt=rt=null;
    }
}

public class BFS {
    BFSNode root;
    public void BFS(BFSNode root){
        Queue<BFSNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            int length = queue.size(); // 자식 몇개인지 확인
            System.out.print(level+" : ");
            for(int i=0; i<length; i++){
                BFSNode currentNode = queue.poll(); //꺼내면서 자식 확인
                System.out.print(currentNode.data+" ");
                if(currentNode.lt != null){
                    queue.offer(currentNode.lt);
                }
                if(currentNode.rt != null){
                    queue.offer(currentNode.rt);
                }
            }//레벨끝
            level++;
            System.out.println();

        }
    }

    public static void main(String[] args){
        BFS tree = new BFS();
        tree.root = new BFSNode(1);
        tree.root.lt = new BFSNode(2);
        tree.root.rt = new BFSNode(3);
        tree.root.lt.lt = new BFSNode(4);
        tree.root.lt.rt = new BFSNode(5);
        tree.root.rt.lt = new BFSNode(6);
        tree.root.rt.rt = new BFSNode(7);
    }
}
