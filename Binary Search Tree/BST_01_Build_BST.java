public class BST_01_Build_BST {
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

    public static void main(String[] args) {
        int []values = {5,1,3,4,2,7};
        Node root = null;
        for (int i=0;i<values.length;i++){
            root = BST(root,values[i]);
        }
        inorder(root);
        System.out.println();
    }
}
