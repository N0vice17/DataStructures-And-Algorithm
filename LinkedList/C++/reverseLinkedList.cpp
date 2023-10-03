#include <iostream>

// Define a singly linked list node structure
struct ListNode {
    int data;
    ListNode* next;
    
    ListNode(int val) : data(val), next(nullptr) {}
};

// Function to reverse a singly linked list
ListNode* reverseLinkedList(ListNode* head) {
    ListNode* prev = nullptr;
    ListNode* current = head;
    ListNode* next = nullptr;

    while (current != nullptr) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    return prev; // New head of the reversed list
}

// Function to print a linked list
void printLinkedList(ListNode* head) {
    while (head != nullptr) {
        std::cout << head->data << " -> ";
        head = head->next;
    }
    std::cout << "nullptr" << std::endl;
}

int main() {
    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);

    std::cout << "Original Linked List: ";
    printLinkedList(head);

    // Reverse the linked list
    head = reverseLinkedList(head);

    std::cout << "Reversed Linked List: ";
    printLinkedList(head);

    // Clean up memory (free the linked list)
    while (head != nullptr) {
        ListNode* temp = head;
        head = head->next;
        delete temp;
    }

    return 0;
}
