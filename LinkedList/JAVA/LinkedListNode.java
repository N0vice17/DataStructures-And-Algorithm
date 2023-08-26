package LinkedList;
import java.util.*;
public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<Integer> next;
    //Start of Singly LinkedList
    /******************************************************************************************************************** */
    public LinkedListNode(T Data,LinkedListNode<Integer>Next) {
        this.data = Data;
        this.next = Next;
    }

    public LinkedListNode(T Data) {
        this.data = Data;
    }
    public LinkedListNode(){

    }
    public static void printList(LinkedListNode<Integer>head) {
        LinkedListNode<Integer>temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void printrecursive(LinkedListNode<Integer>head){
        if(head==null){
            System.out.println( );
            return;
        }
        System.out.print(head.data+" ");
        printrecursive(head.next);
    }

    public static LinkedListNode<Integer>takeInput() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        LinkedListNode<Integer>head = null, tail = null;
        while (num != -1) {
            LinkedListNode<Integer>temp = new LinkedListNode<Integer>(num);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            num = input.nextInt();
        }
        input.close();
        return head;
    }

    public static LinkedListNode<Integer>InsertNode(LinkedListNode<Integer>head, int position, int value) {
        LinkedListNode<Integer>temp = head;
        int count = 0;
        if (position == 0) {
            LinkedListNode<Integer>insert = new LinkedListNode<Integer>(value,temp);
            temp = insert;
            return temp;
        } else {
            while (count != position - 1) {
                if (temp == null) {
                    break;
                }
                temp = temp.next;
                count++;
            }
            if (position > count && temp == null) {
                return head;
            } else {
                if (temp.next == null) {
                    LinkedListNode<Integer>Insert = new LinkedListNode<Integer>(value, null);
                    temp.next = Insert;
                } else {
                    LinkedListNode<Integer>insert = new LinkedListNode<Integer>(value,temp.next);
                    temp.next = insert;
                }
                return head;
            }
        }
    }
    public static LinkedListNode<Integer>DeleteNode(LinkedListNode<Integer>head,int position){
        LinkedListNode<Integer>temp=head;
        if(position==0){
            head=temp.next;
            return head;
        }
        else{
            int count=0;
            while(count!=position-1){
                if(temp.next==null){
                    break;
                }
                temp=temp.next;
                count++;
            }
            if(position>count&&temp.next==null){
                return head;
            }
            else{
            temp.next=temp.next.next;
            return head;
            }
        }
    }
    public static LinkedListNode<Integer>InsertRecursive(LinkedListNode<Integer>head, int element,int position){
        if(head==null&&position>=0){
            return head;
        }
        if(position==0){
            LinkedListNode<Integer>newnode=new LinkedListNode<Integer>(element);
            newnode.next=head;
            return newnode;
        }
        else{
            head.next=InsertRecursive(head.next,element,position-1);
            return head;
        }
    }
    public static LinkedListNode<Integer>DeleteRecursive(LinkedListNode<Integer>head,int position){
        if(head==null&&position>=0){
            return head;
        }
        if(position==0){
            return head.next;
        }
        else{
            head.next=DeleteRecursive(head.next,position-1);
            return head;
        }
    }
    public static LinkedListNode<Integer>ReverseRevursive(LinkedListNode<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        LinkedListNode<Integer>Smallhead=ReverseRevursive(head.next);
        LinkedListNode<Integer>tail=Smallhead;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=head;
        head.next=null;
        return Smallhead;
    }
    public static LinkedListNode<Integer>ReverseBest(LinkedListNode<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        LinkedListNode<Integer>smallhead=ReverseBest(head.next);
        LinkedListNode<Integer>tail=head.next;
        tail.next=head;
        head.next=null;
        return smallhead;
    }
    public static void FindMid(LinkedListNode<Integer>head){
        LinkedListNode<Integer>slow=head;
        LinkedListNode<Integer>fast=head;
        if(head==null){
        System.out.println(-1);    
        }
        else{
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
        }
    }
    //End of Singly LinkedList
    /*********************************************************************************************************************/
}
