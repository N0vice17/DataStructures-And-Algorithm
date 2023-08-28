package Queue;
import LinkedList.*;
public class QueueUsingLL {
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> rear;
    int size;
    public QueueUsingLL(){
        head=null;
        rear=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int front(){
        return head.data;
    }
    public void enqueue(int element){
        LinkedListNode<Integer> temp=new LinkedListNode<Integer>(element);
        if(head==null){
            head=temp;
            rear=temp;
            rear.next=null;
        }
        else{
            rear.next=temp;
            rear=temp;
            rear.next=null;
        }
        size++;
    }
    public int dequeue(){
        if(size==0){
          return -1;
        }
        else{
        int data=head.data;
        if(head.next==null){
            head=null;
            rear=null;
        }
        else{
            head=head.next;
            }
        size--;
        return data;
        }
    }
    public void print(){
        if(head==null){
            System.out.println("Queue Is Empty");
        }
        else{
        LinkedListNode<Integer> temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
        System.out.println( );
    }
}
