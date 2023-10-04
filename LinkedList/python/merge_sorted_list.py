class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_sorted_lists(l1, l2):
    # Create a dummy node to simplify the code
    dummy = ListNode()
    current = dummy
    
    while l1 and l2:
        if l1.val < l2.val:
            current.next = l1
            l1 = l1.next
        else:
            current.next = l2
            l2 = l2.next
        current = current.next
    
    # Attach any remaining elements from l1 or l2
    if l1:
        current.next = l1
    if l2:
        current.next = l2
    
    return dummy.next

def print_linked_list(head):
    current = head
    while current:
        print(current.val, end=" -> ")
        current = current.next
    print("None")

# Input: Read two lists of sorted numbers separated by spaces
input_list1 = input("Enter the first sorted list of numbers separated by spaces: ").split()
input_list2 = input("Enter the second sorted list of numbers separated by spaces: ").split()

# Convert input to integer lists
list1 = [int(x) for x in input_list1]
list2 = [int(x) for x in input_list2]

# Create two sorted linked lists from the input
l1 = None
l2 = None

# Create the first linked list (l1)
for val in list1:
    if not l1:
        l1 = ListNode(val)
        current = l1
    else:
        current.next = ListNode(val)
        current = current.next

# Create the second linked list (l2)
for val in list2:
    if not l2:
        l2 = ListNode(val)
        current = l2
    else:
        current.next = ListNode(val)
        current = current.next

print("\nSorted Linked List 1:")
print_linked_list(l1)

print("\nSorted Linked List 2:")
print_linked_list(l2)

# Merge the two sorted linked lists
merged_list = merge_sorted_lists(l1, l2)
print("\nMerged Sorted Linked List:")
print_linked_list(merged_list)
