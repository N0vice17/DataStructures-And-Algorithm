package LinkedList;
public class MergeSort_LinkedList {
    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> left, LinkedListNode<Integer> right){
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        LinkedListNode<Integer> ans=new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> temp=ans;
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
    public static LinkedListNode<Integer> MergeSort(LinkedListNode<Integer> head){
        if(head==null||head.next==null){
            return head;
        }
        LinkedListNode<Integer> slow=head;
        LinkedListNode<Integer> fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        LinkedListNode<Integer> left=head;
        LinkedListNode<Integer> right=slow.next;
        slow.next=null;
        left=MergeSort(left);
        right=MergeSort(right);
        LinkedListNode<Integer> result=merge(left,right);
        return result;
    }
    public static void main(String[]args){
        LinkedListNode<Integer> six=new LinkedListNode<Integer>(1,null);
        LinkedListNode<Integer> five=new LinkedListNode<Integer>(2,six);
        LinkedListNode<Integer> four=new LinkedListNode<Integer>(3,five);
        LinkedListNode<Integer> three=new LinkedListNode<Integer>(4,four);
        LinkedListNode<Integer> two=new LinkedListNode<Integer>(5,three);
        LinkedListNode<Integer> one=new LinkedListNode<Integer>(6,two);
        LinkedListNode<Integer> head=MergeSort(one);
        LinkedListNode.printList(head);
    }
}
