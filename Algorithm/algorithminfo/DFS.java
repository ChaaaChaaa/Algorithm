package algorithminfo;

class DFSNode{
    int data;
    DFSNode lt,rt;
    public DFSNode(int val){
        data = val;
        lt=rt=null;
    }
}

public class DFS {
    DFSNode root;
    public void DFS(DFSNode root){
        if(root == null){
            return;
        }
        else{
            // 전위 : System.out.print(root.data+" ");
            DFS(root.lt);
            // 중위 System.out.print(root.data+" ");
            DFS(root.rt);
            // 후위 System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args){
        DFS tree = new DFS();
        tree.root = new DFSNode(1);
        tree.root.lt = new DFSNode(2);
        tree.root.rt = new DFSNode(3);
        tree.root.lt.lt = new DFSNode(4);
        tree.root.lt.rt = new DFSNode(5);
        tree.root.rt.lt = new DFSNode(6);
        tree.root.rt.rt = new DFSNode(7);
    }
}
