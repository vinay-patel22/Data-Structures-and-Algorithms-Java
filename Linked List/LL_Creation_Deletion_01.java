public class LL_Creation_Deletion_01 {
    public static void main(String[] args) {
        LL list = new LL();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.printl();

        list.addFirst(40);
        list.printl();
        System.out.println(list.getSize());
    }
    public static class LL{
        public class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
                size++;
            }
        }
        Node head;
        private int size;
        LL(){
            size=0;
        }
        public void addFirst(int data){
            Node newNode = new Node(data);

            newNode.next = head;
            head = newNode;

        }
        public void addLast(int data){
            Node newNode = new Node(data);
            if (head == null){
                head = newNode;
                return;
            }
            Node lastNode =head;
            while (lastNode.next!=null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        public void printl(){
            Node currNode = head;
            while (currNode != null){
                System.out.print(currNode.data+"->");
                currNode = currNode.next;
            }
            System.out.println("null");
        }
        public void removeFrist(){
            if (head == null){
                System.out.println("Nothing to delete");
                return;
            }
            head = this.head.next;
            size--;
        }
        public void removeLast(){
            if (head == null){
                System.out.println("Nothing to delete");
                return;
            }
            if (head.next == null){
                head = null;
                return;
            }
            size--;
            Node currNode = head;
            Node lastNode = head.next;
            while (lastNode.next != null){
                currNode = currNode.next;
                lastNode = lastNode.next;
            }
            currNode.next = null;
        }
        public int getSize(){
            return size;
        }
    }
}
