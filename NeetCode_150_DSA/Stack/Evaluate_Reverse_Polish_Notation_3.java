package NeetCode_150_DSA.Stack;

public class Evaluate_Reverse_Polish_Notation_3 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 1] += stack[top];
                    top--;
                    break;

                case "-":
                    stack[top - 1] -= stack[top];
                    top--;
                    break;

                case "*":
                    stack[top - 1] *= stack[top];
                    top--;
                    break;

                case "/":
                    stack[top - 1] /= stack[top];
                    top--;
                    break;

                default:
                    stack[++top] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[0];
    }

}