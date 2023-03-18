public class BST_02_Search_key_in_BST {
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
    public static boolean BSTSearch(Node root,int key){
        if (root == null){
            return false;
        }

        if (root.data > key){
            return BSTSearch(root.left,key);
        } else if (root.data < key) {
            return BSTSearch(root.right,key);
        }
        else {
            return true;
        }
    }
    public static void main(String[] args) {
        int []values = {5,1,3,4,2,7};
        Node root = null;
        for (int i=0;i<values.length;i++){
            root = BST(root,values[i]);
        }
        System.out.println();
        if (BSTSearch(root,4)){
            System.out.println("Found");
        }else {
            System.out.println("Not Found");
        }
    }
}
