// Detect Loop in linked list

// Method 1 : Detect loop in a linked list using Hashing


import java.util.*;
 
public class LinkedList {
 
    static Node head; // head of list
 
    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Inserts a new Node at front of the list. */
    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    // Returns true if there is a loop in linked
    // list else returns false.
    static boolean detectLoop(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
            // If we have already has this node
            // in hashmap it means there is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(h))
                return true;
 
            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(h);
 
            h = h.next;
        }
 
        return false;
    }
 
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
 
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
 
        if (detectLoop(head))
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }
}
 
// This code is contributed by Arnav Kr. Mandal





import java.util.LinkedList;

import static java.util.Collections.reverse;

public class LL_Most_Aksed_Qun_03 {
    public static void main(String[] args) {
        LL ls = new LL();
        ls.addFirst(10);
        ls.addFirst(20);
        ls.addFirst(30);
        ls.addFirst(40);
        ls.printl();

//        ls.removeNthFromEnd(ls.head,2);
//        ls.printl();

          ls.isPalindrome(ls.head);
//        ls.printl();

    }
    public static class LL {
        public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
        ListNode head;
        public void addFirst(int data){
            ListNode newNode = new ListNode(data);

            newNode.next = head;
            head = newNode;

        }

        public void printl(){
            ListNode currNode = head;
            while (currNode != null){
                System.out.print(currNode.val+"->");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {

            // Time :- O(n)
            // Space :- O(1)

            if (head.next == null) {
                return null;
            }
            int size = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                size++;
            }
            // Now We Remove sizeth node from last i.e head
            if (n == size) {
                return head.next;
            }
            int positionToFind = size - n;
            ListNode previousNode = head;
            int currentPosition = 1;

            while (currentPosition != positionToFind) {
                previousNode = previousNode.next;
                currentPosition++;
            }
            previousNode.next = previousNode.next.next;
            return head;
        }

        public static boolean isPalindrome(ListNode head){
            if (head == null || head.next == null){
                return true;
            }
            ListNode firstHalfEnd = getMiddle(head);
            ListNode secondHalfStart = reverse(firstHalfEnd.next);
            ListNode firstHalfStart = head;

            while (secondHalfStart != null){
                if (secondHalfStart.val != firstHalfStart.val){
                    return false;
                }
                secondHalfStart = secondHalfStart.next;
                firstHalfStart = firstHalfStart.next;
            }
            return true;
        }

        public static ListNode getMiddle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
        public static ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
