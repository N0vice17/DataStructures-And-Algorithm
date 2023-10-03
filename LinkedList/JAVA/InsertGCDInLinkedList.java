/*
 * Given the head of a linked list head, in which each node contains an integer value.

    Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

    Return the linked list after insertion.

    The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

    

    Example 1:


    Input: head = [18,6,10,3]
    Output: [18,6,6,2,10,1,3]
    Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
    - We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
    - We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
    - We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
    There are no more adjacent nodes, so we return the linked list.
 */

public class InsertGCDInLinkedList {
    static int findGCD(int n1, int n2) {
        int rem = n1%n2;
        while(rem > 0) {
            n1 = n2;
            n2 = rem;
            rem = n1%n2;
        }

        return n2;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;

        while(temp.next != null) {
            int gcd = findGCD(temp.data, temp.next.data);
            ListNode n = new ListNode(gcd, temp.next);
            temp.next = n;
            temp = temp.next.next;
        }

        return head;
    }
    
}

class ListNode {
    int data;
    ListNode next;

    public ListNode() {}

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
