# Title: 92. Reverse Linked List II
# Difficulty: Medium
# Problem: https://leetcode.com/problems/reverse-linked-list-ii/description/

## Changing the values of the node

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        # create a dummy head for cases with left = 1
        dummy = ListNode(next=head)

        # reach the left node
        counter = left - 1
        node = head
        while counter:
            node = node.next
            counter -= 1

        # store the values of the node between left and right (inclusive)
        values = []
        start = node
        counter = right - left + 1
        while counter:
            values.append(node.val)
            node = node.next
            counter -= 1

        # fill the reversed values
        counter = right - left + 1
        while counter:
            start.val = values[counter-1]
            start = start.next
            counter -= 1

        return dummy.next

## Changing the nodes

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head:
            return None
        cur, prev = head, None
        while left >1:
            prev = cur
            cur = cur.next
            left -= 1
            right -=1
        tail, con = cur, prev

        while right:
            cur.next, prev, cur = prev, cur, cur.next
            right -=1

        if con:
            con.next = prev
        else:
            head = prev
        tail.next = cur
        return head
