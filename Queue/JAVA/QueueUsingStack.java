package Queue.JAVA;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public void enqueue(int val) {
        enqueueStack.push(val);
    }

    private void transferElements() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        if (dequeueStack.isEmpty()) {
            transferElements();
        }
        return dequeueStack.pop();
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        if (dequeueStack.isEmpty()) {
            transferElements();
        }
        return dequeueStack.peek();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        if (!dequeueStack.isEmpty()) {
            for (int i = dequeueStack.size() - 1; i >= 0; i--) {
                System.out.print(dequeueStack.get(i) + " ");
            }
        } else {
            for (int i = 0; i < enqueueStack.size(); i++) {
                System.out.print(enqueueStack.get(i) + " ");
            }
        }
        System.out.println();
    }

}
