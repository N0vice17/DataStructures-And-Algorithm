package Queue.JAVA;

import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayList {
    List<Integer> queue = new ArrayList<>();

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void enqueue(int val){
        queue.add(val);
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        return queue.remove(0);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        return queue.get(0);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        for(int i=0; i<queue.size(); i++){
            System.out.print(queue.get(i) + " ");
        }
        System.out.println();
    }

}
