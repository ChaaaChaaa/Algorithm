import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1991 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        char[] data;

        for(int i=0; i<n; i++){
            data = br.readLine().replaceAll(" ","").toCharArray();
            tree.add(data[0],data[1],data[2]);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }


}

class Node{
    char data;
    Node left,right;
    Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Tree{
    Node root;

    void add(char data, char leftData, char rightData){
     if(root == null){
         if(data != '.') root = new Node(data);
         if(leftData != '.'){
             if (root != null) {
                 root.left = new Node(leftData);
             }
         }
         if(rightData != '.'){
             if (root != null) {
                 root.right = new Node(rightData);
             }
         }
     }
     if(root != null){
         search(root,data,leftData,rightData);
     }

    }
    private void search(Node root, char data, char leftData, char rightData){
        if(root == null){
            return;
        }
        if(root.data == data){
            if(leftData != '.'){
                root.left = new Node(leftData);
            }
            if(rightData != '.'){
                root.right = new Node(rightData);
            }
        }
        if(root.data != data){
            search(root.left,data,leftData,rightData);
            System.out.println("1 root.left :"+root.left);
            System.out.println("2 data :"+data);
            System.out.println("3 leftData :"+leftData);
            System.out.println("4 +rightData :"+rightData);
            System.out.println("1차: ");
            inOrder(root);
            System.out.println("-------------------------------");
            search(root.right,data,leftData,rightData);
            System.out.println("2-1 root.right :"+root.right);
            System.out.println("2-2 data :"+data);
            System.out.println("2-3 leftData :"+leftData);
            System.out.println("2-4 rightData :"+rightData);
            System.out.println("2차: ");
            inOrder(root);
            System.out.println("-------------------------------");
        }

    }
    void preOrder(Node root){
        System.out.print(root.data);
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }

    }
    void inOrder(Node root){
        if(root.left != null){
            inOrder(root.left);
        }
        System.out.print(root.data);
        if(root.right != null){
            inOrder(root.right);
        }

    }
    void postOrder(Node root){
        if(root.left != null){
            postOrder(root.left);
        }
        if(root.right != null){
            postOrder(root.right);
        }
        System.out.print(root.data);

    }

}
