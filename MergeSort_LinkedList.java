public class MergeSort_LinkedList {
    public static Node merge(Node left,Node right){
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        Node ans=new Node(-1);
        Node temp=ans;
        while(left!=null&&right!=null){
            if(left.data<=right.data){
                temp.next=left;
                temp=left;
                left=left.next;
            }
            else{
                temp.next=right;
                temp=right;
                right=right.next;
            }
        }
        while(left!=null){
            temp.next=left;
            temp=left;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            temp=right;
            right=right.next;
        }
        ans=ans.next;
        return ans;
    }
    public static Node MergeSort(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node left=head;
        Node right=slow.next;
        slow.next=null;
        left=MergeSort(left);
        right=MergeSort(right);
        Node result=merge(left,right);
        return result;
    }
    public static void main(String[]args){
        Node six=new Node(1,null);
        Node five=new Node(2,six);
        Node four=new Node(3,five);
        Node three=new Node(4,four);
        Node two=new Node(5,three);
        Node one=new Node(6,two);
        Node head=MergeSort(one);
        Node.printList(head);
    }
}
