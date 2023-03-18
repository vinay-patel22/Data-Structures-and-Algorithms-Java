import java.util.ArrayList;

public class BST_04_Questions {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static Node BST(Node root,int val){
        if (root == null){
            root = new Node(val);
            return root;
        }
        if (root.data > val){
            // isert in left
            root.left = BST(root.left,val);
        }else {
            root.right = BST(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }

    public static void printInRange(Node root,int x,int y){
        if (root==null){
            return;
        }

        if (root.data>=x && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        } else if (root.data >= y) {
            printInRange(root.left,x,y);
        }else {
            printInRange(root.right,x,y);
        }
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);
        // leaf node condition
        if (root.left == null && root.right==null){
            printpath(path);
        }else {  // non-leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right,path);
        }
        path.remove(path.size()-1); // last index hoy aene remove karisu
    }
    public static void printpath(ArrayList<Integer>path){
        for (int i=0;i<path.size();i++){
            System.out.println(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []values = {8,5,3,6,10,11,14};
        Node root = null;
        for (int i=0;i<values.length;i++){
            root = BST(root,values[i]);
        }
        inorder(root);
        System.out.println();

//        printInRange(root,6,10);
        printRoot2Leaf(root,new ArrayList<>());

    }
}
