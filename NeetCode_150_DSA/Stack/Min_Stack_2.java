package NeetCode_150_DSA.Stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> s; // stack
    private Stack<Integer> miniS; // minStack

    public MinStack() {
        s = new Stack<>();
        miniS = new Stack<>();
    }

    public void push(int value) {
        s.push(value);

        if (miniS.isEmpty() || value <= miniS.peek()) {
            miniS.push(value);
        }
    }

    public void pop() {
        if (!s.isEmpty()) {
            int popped = s.pop();

            if (!miniS.isEmpty() && popped == miniS.peek()) {
                miniS.pop();
            }
        }
    }

    public int top() {
        if (!s.isEmpty()) {
            return s.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!miniS.isEmpty()) {
            return miniS.peek();
        }
        return -1;
    }

}

public class Min_Stack_2 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        int value;
        obj.push(value);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

}
