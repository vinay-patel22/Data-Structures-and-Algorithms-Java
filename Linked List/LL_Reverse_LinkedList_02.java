import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class LL_Reverse_LinkedList_02 {
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
//        list.printl();

//        list.reverseLL();
//        list.head = list.reverse(list.node);
//        list.printl();
//        list.reverse(list.head);
//        list.printl();
//


//        Method 3:- Using Collection method .. Time:-O(n) Space:-O(1)
        LinkedList<Integer>ls = new LinkedList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        System.out.println(ls);
        Collections.reverse(ls);
        System.out.println(ls);
    }

    public static class LL{
        public class node{
            int data;
            node next;
            node(int data){
                this.data = data;
                this.next = next;
            }
        }
        node head;
        public void addFirst(int data){
            node newNode = new node(data);

            newNode.next = head;
            head = newNode;

        }
        public void printl(){
         node currNode = head;
            while (currNode != null){
                System.out.print(currNode.data+"->");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

//      Method 1:- Using Itterative .. Time:-O(n) Space:-O(1)
        public void reverseLL(){
            if (head == null || head.next == null){
                return;
            }
            node prevnode = head;
            node currnode = head.next;

            while (currnode != null){
                node nextnode = currnode.next;
                currnode.next = prevnode;
                prevnode = currnode;
                currnode = nextnode;
            }
            head.next = null;
            head = prevnode;
        }


//      Method 2:- Using recursion .. Time:-O(n) Space:-O(1)
            public node reverse(node head){
//            empty node || last node or only one node
            if (head == null || head.next == null){
                return head;
            }
            node newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
