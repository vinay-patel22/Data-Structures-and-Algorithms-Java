import java.util.*;

public class Reverse_LevelOrder_Traversal {

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

    static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode == null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data+"");
                if (currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right !=null){
                    q.add(currNode.right );
                }
            }

        }
    }


//    below solution is uploaded in GFG answer in my account
    public static ArrayList<Integer> reverseLevelOrder(Node node)
    {

        /*
        Got TLE of below code because

        The time complexity of the current solution is O(N^2)
        where N is the number of nodes in the binary tree.
        This is because we are using a queue to perform level order traversal,
        which takes O(N) time, and for each node, we are pushing it onto a stack,
        which takes O(N) time as well.

        */

        // ArrayList<Integer> result = new ArrayList<>();

        // Stack<Node> stack = new Stack<>();
        // Queue<Node> queue = new LinkedList<>();

        // queue.add(node);

        // while (!queue.isEmpty()) {

        //     node = queue.peek();
        //     stack.push(node);

        //     if (node.right != null) {
        //         queue.add(node.right);
        //     }

        //     if (node.left != null) {
        //         queue.add(node.left);
        //     }
        // }

        // while (!stack.isEmpty()) {
        //     node = stack.pop();
        //     result.add(node.data);
        // }

        // return result;




        // The time complexity of this below solution is O(N),
        // since we perform a constant amount of work for each node in the binary tree.


        ArrayList<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();

        if (node != null) {
            deque.add(node);
        }

        while (!deque.isEmpty()) {
//            deque.poll() is Returns:-
//            the first element of this deque, or null if this deque is empty
            node = deque.poll();
            result.add(0, node.data);

            if (node.right != null) {
                deque.add(node.right);
            }

            if (node.left != null) {
                deque.add(node.left);
            }
        }

        return result;
    }

    static void reversLevelOrder(Node node){
        Stack<Node>s = new Stack<>();
        Queue<Node>q = new LinkedList<>();

        q.add(node);
        while (!q.isEmpty()){
            node = q.peek();
            q.remove();
            s.push(node);

            if (node.right!=null){
                q.add(node.right);
            }
            if (node.left!=null){
                q.add(node.left);
            }

        }
        while (!s.isEmpty()){
            node = s.peek();
            System.out.print(node.data+" ");
            s.pop();
        }
    }

    public static void main(String[] args) {
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        levelOrder(root);
        reversLevelOrder(root);
    }
}
