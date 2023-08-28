class Node {
    public int data;
    public Node next, prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    private Node head = null, tail = null;

    private int countNode() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void createDoublyLinkedList(int data) {
        Node newNode = new Node(data);
        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 1 || position > countNode())
            System.exit(1);
        else if (position == 1)
            insertAtBeginning(data);
        else {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 1; i < position - 1; i++)
                temp = temp.next;
            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.next.prev = newNode;
        }
    }

    public void deleteFromBeginning() {
        Node temp = head;
        if (head == null)
            System.exit(2);
        head = head.next;
        if (head != null)
            head.prev = null;
        temp = null;
    }

    public void deleteFromEnd() {
        if (tail == null)
            System.exit(3);
        Node temp = tail;
        if (tail.prev != null)
            tail.prev.next = null;
        tail = tail.prev;
        temp = null;
    }

    public void deleteFromPosition(int position) {
        if (position < 1 || position > countNode())
            System.exit(4);
        if (position == 1)
            deleteFromBeginning();
        else if (position == countNode())
            deleteFromEnd();
        else {
            Node temp = head;
            for (int i = 1; i < position; i++)
                temp = temp.next;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp = null;
        }
    }

    public void reverseList() {
        Node currentNode, nextNode;
        currentNode = head;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = currentNode.prev;
            currentNode.prev = nextNode;
            currentNode = nextNode;
        }
        currentNode = head;
        head = tail;
        tail = currentNode;
    }

    public void displayList() {
        if (head == null)
            System.exit(2);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.createDoublyLinkedList(3);
        l1.createDoublyLinkedList(4);
        l1.createDoublyLinkedList(5);
        l1.insertAtBeginning(1);
        l1.insertAtPosition(2, 2);
        l1.insertAtEnd(6);
        // l1.deleteFromBeginning();
        // l1.deleteFromEnd();
        // l1.deleteFromPosition(2);
        // l1.deleteFromPosition(1);
        // l1.deleteFromPosition(2);
        // l1.displayList();
        l1.displayList();
        l1.reverseList();
        l1.displayList();
    }
}
