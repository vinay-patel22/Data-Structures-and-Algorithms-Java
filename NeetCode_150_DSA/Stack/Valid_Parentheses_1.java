package NeetCode_150_DSA.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses_1 {

    public static void main(String[] args) {

    }
      public boolean isValid(String s) {
        // Brute Force
        /*
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else if(c==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else if(c=='}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }else if(c==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
        */

        // We can eliminate the need for the separate if-else statements by using a map to store the mappings of opening and closing parentheses
         Stack<Character> stack = new Stack<>();
         Map<Character, Character> mappings = new HashMap<>();

        mappings.put(')','(');
        mappings.put('}','{');
        mappings.put(']','[');

        for(char c:s.toCharArray()){
            if(mappings.containsKey(c)){
                char topEle = stack.isEmpty() ? '#' : stack.pop();
                if(topEle != mappings.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}