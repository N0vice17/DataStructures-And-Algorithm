import java.util.*;
public class Node {
    public int data;
    public Node next;
    //Start of Singly LinkedList
    /******************************************************************************************************************** */
    public Node(int Data, Node Next) {
        this.data = Data;
        this.next = Next;
    }

    public Node(int Data) {
        this.data = Data;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void printrecursive(Node head){
        if(head==null){
            System.out.println( );
            return;
        }
        System.out.print(head.data+" ");
        printrecursive(head.next);
    }

    public static Node takeInput() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Node head = null, tail = null;
        while (num != -1) {
            Node temp = new Node(num);
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

    public static Node InsertNode(Node head, int position, int value) {
        Node temp = head;
        int count = 0;
        if (position == 0) {
            Node insert = new Node(value, temp);
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
                    Node Insert = new Node(value, null);
                    temp.next = Insert;
                } else {
                    Node insert = new Node(value, temp.next);
                    temp.next = insert;
                }
                return head;
            }
        }
    }
    public static Node DeleteNode(Node head,int position){
        Node temp=head;
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
    public static Node InsertRecursive(Node head, int element,int position){
        if(head==null&&position>=0){
            return head;
        }
        if(position==0){
            Node newnode=new Node(element);
            newnode.next=head;
            return newnode;
        }
        else{
            head.next=InsertRecursive(head.next,element,position-1);
            return head;
        }
    }
    public static Node DeleteRecursive(Node head,int position){
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
    public static Node ReverseRevursive(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node Smallhead=ReverseRevursive(head.next);
        Node tail=Smallhead;
        while(tail.next!=null){ 
            tail=tail.next;
        }
        tail.next=head;
        head.next=null;
        return Smallhead;
    }
    public static Node ReverseBest(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node smallhead=ReverseBest(head.next);
        Node tail=head.next;
        tail.next=head;
        head.next=null;
        return smallhead;
    }
    public static void FindMid(Node head){
        Node slow=head;
        Node fast=head;
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
