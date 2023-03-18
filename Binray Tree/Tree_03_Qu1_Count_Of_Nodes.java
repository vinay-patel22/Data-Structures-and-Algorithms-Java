public class Tree_03_Qu1_Count_Of_Nodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int []nodes){
            idx++;
            if (nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static int countOfNodes(Node root){
        if (root == null){
            return 0;
        }
        int leftNode = countOfNodes(root.left);
        int rightNode = countOfNodes(root.right);
        return leftNode+rightNode+1;
    }
    public static int sumOfNodes(Node root){
        if (root == null){
            return 0;
        }
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);
        return leftsum+rightsum+root.data;
    }

    public static int hight(Node root){
        if (root == null){
            return 0;
        }

        int leftHeight = hight(root.left);
        int rightHeight = hight(root.right);
        int totalHeight = Math.max(leftHeight , rightHeight) + 1;
        return totalHeight;
    }

    // Adobe Snapdeal Question...

    //Approach 1:- O(n^2)
    public static int diameter(Node root){
        if (root == null){
            return 0;
        }

        int diam1LeftSubTree = diameter(root.left);
        int diam2RightSubTree = diameter(root.right);
        int diam3 = hight(root.left) + hight(root.right) + 1;  // n*n
        return Math.max(diam3,Math.max(diam1LeftSubTree,diam2RightSubTree));
    }
    //Approach 2:- O(n)

    public static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameter2(Node root){
        if (root == null){
            return new TreeInfo(0,0);
        }

        TreeInfo left =  diameter2(root.left);
        TreeInfo right = diameter2(root.right);
        int totalHeight = Math.max(left.ht,right.ht) +1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        int totalDiam = Math.max(Math.max(diam1,diam2),diam3);

        TreeInfo myInfo = new TreeInfo(totalHeight,totalDiam);
        return myInfo;
    }


//    FANG Question :- Subtree of another tree
//    SOlved In Leetcode...
    public static void main(String[] args) {
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

//        System.out.println(countOfNodes(root));
//        System.out.println(sumOfNodes(root));
//        System.out.println(hight(root));

//        System.out.println(diameter(root));
        System.out.println(diameter2(root).diam);

    }

}
