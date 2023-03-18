import java.util.ArrayList;

public class Stack_Array_List_02 {
    public static void main(String[] args) {
        stackAL s = new stackAL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
    public static class stackAL{
        ArrayList<Integer>ls = new ArrayList<>();

        public void push(int data){
            ls.add(data);
        }
        public boolean isEmpty(){
            return ls.size()==0;
        }
        public int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = ls.remove(ls.size()-1);
            return top;
        }
        public int peek(){
            if (isEmpty()){
                return -1;
            }
            return ls.get(ls.size()-1);
        }
    }
}
