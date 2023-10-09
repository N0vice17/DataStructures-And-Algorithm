
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue = new LinkedList<>();

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void push(int val) {
        queue.offer(val);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int peek() {
        return queue.peek();
    }

    public void display() {
        for (Integer item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
