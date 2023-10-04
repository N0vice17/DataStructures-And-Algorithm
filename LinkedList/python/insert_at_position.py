class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def insert_at_position(head, value, position):
    new_node = ListNode(value)
    
    # Insert at the beginning if the position is 1
    if position == 1:
        new_node.next = head
        return new_node
    
    current = head
    count = 1

    # Traverse the linked list to find the position before insertion
    while current and count < position - 1:
        current = current.next
        count += 1

    # Check if the position is out of bounds
    if not current:
        print(f"Position {position} is out of bounds.")
        return head

    # Insert the new node at the specified position
    new_node.next = current.next
    current.next = new_node

    return head

def print_linked_list(head):
    current = head
    while current:
        print(current.val, end=" -> ")
        current = current.next
    print("None")

# Input: Read a list of numbers separated by spaces
input_list = input("Enter a list of numbers separated by spaces: ").split()
input_list = [int(x) for x in input_list]

# Create a linked list from the input: 1 -> 2 -> 4 -> 5
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

# Input: Read the value and position to insert
insert_value = int(input("Enter the value to insert: "))
insert_position = int(input("Enter the position to insert: "))

# Insert the value at the specified position
new_head = insert_at_position(head, insert_value, insert_position)
print("\nLinked List After Insertion:")
print_linked_list(new_head)
    