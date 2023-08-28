package Stack;
import LinkedList.*;
public class StackUsingLL{
    LinkedListNode<Integer> head;
    int size;
    public StackUsingLL(){
        head=null;
        size=0;
    }  
    public boolean isEmpty(){
        return size==0;
    } 
    public void push(int element){
        LinkedListNode<Integer> temp1=new LinkedListNode<Integer>(element);
        temp1.next=head;
        head=temp1;
        size++;
    }
    public void pop(){
        head=head.next;
        size--;
    }
    public int top(){
        if(size==0){
            return -1;
        }
        else{
        return head.data;
        }
    }
    public int size(){
        return size;
    }
}
