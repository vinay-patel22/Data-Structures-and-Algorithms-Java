public class BST_03_Delete_Node {
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

    public static Node delete(Node root,int val){
        if (root.data > val){
           root.left= delete(root.left,val);
        } else if (root.data < val) {
            root.right = delete(root.right,val);
        }else {
            // case 1 -> NO CHILD(LEAF NODE)
            if (root.left == null && root.right == null){
                return null;
            }
            // case 2 -> ONE CHILD
            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3  -> Two Children
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;  // for attached data root->delete data
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    public static Node inOrderSuccessor(Node root){
        while (root.left != null){
            root = root.left;
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
        int []values = {58,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i=0;i<values.length;i++){
            root = BST(root,values[i]);
        }
        inorder(root);
        System.out.println();

        delete(root,5);
        inorder(root);
    }
}
