import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||
                    s.charAt(i) == '{' ||
                    s.charAt(i) == '[') {
                myStack.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (myStack.isEmpty() || myStack.pop() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (myStack.isEmpty() || myStack.pop() != '[') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (myStack.isEmpty() || myStack.pop() != '{') {
                    return false;
                }
            }
        }

        if (myStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}