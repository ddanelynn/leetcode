import java.util.*;

public class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;

    public MinStack() {
        this.s = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        this.s.push(val);
        if (minStack.empty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.add(minStack.peek());
        }
    }

    public void pop() {
        s.pop();
        minStack.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
