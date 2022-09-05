import java.util.*;

public class StackInQueue {
    Queue<Integer> q;
    int size;
    int up;

    public StackInQueue() {
        this.q = new LinkedList<>();
        this.size = 0;
    }

    public void push(int x) {
        this.q.add(x);
        this.size++;
        this.up = x;
    }

    public int pop() {
        for (int i = 0; i < this.size - 1; i++) {
            int temp = this.q.peek();
            up = temp;
            this.q.poll();
            this.q.add(temp);
        }
        size--;
        return this.q.poll();
    }

    public int top() {
        return this.up;
    }

    public boolean empty() {
        return size == 0;
    }
}
