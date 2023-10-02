package Stack.JAVA;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
    List<Integer> stack = new ArrayList<>();

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(int val){
        stack.add(val);
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack.remove(stack.size()-1);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack.get(stack.size()-1);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        for(int i=stack.size()-1; i>=0; i--){
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
}
