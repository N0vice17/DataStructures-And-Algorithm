/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){

        }
    public ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = temp1;
        int carryOver = 0;
        while(l1 != null || l2!= null)
        {
            int digit1 = (l1 != null)?l1.val:0;
            int digit2 = (l2 != null)?l2.val:0;
            int sum = carryOver + digit1 + digit2;
            carryOver = sum/10;
            temp2.next = new ListNode(sum%10);
            temp2 = temp2.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carryOver>0)
            temp2.next = new ListNode(carryOver);
        return temp1.next;
    }
}
