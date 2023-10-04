class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def find_middle(head):
    if not head:
        return None

    slow_ptr = head
    fast_ptr = head

    # Use the slow and fast pointer technique to find the middle element
    while fast_ptr and fast_ptr.next:
        slow_ptr = slow_ptr.next
        fast_ptr = fast_ptr.next.next

    return slow_ptr

def print_linked_list(head):
    current = head
    while current:
        print(current.val, end=" -> ")
        current = current.next
    print("None")

# Input: Read a list of numbers separated by spaces
input_list = input("Enter a list of numbers separated by spaces: ").split()
input_list = [int(x) for x in input_list]

# Create a linked list from the input
head = None
current = None
for val in input_list:
    if not head:
        head = ListNode(val)
        current = head
    else:
        current.next = ListNode(val)
        current = current.next

print("\nOriginal Linked List:")
print_linked_list(head)

# Find the middle element of the linked list
middle_node = find_middle(head)
if middle_node:
    print("\nMiddle Element:", middle_node.val)
else:
    print("\nList is empty")
