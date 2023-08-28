class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head = null;

    private int countNode() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtLast(int data) {
        if (head == null)
            insertAtBeginning(data);
        else {
            Node newNode = new Node(data);
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        if (position > countNode())
            System.exit(1);
        Node newNode = new Node(data);
        Node temp = head;
        int i = 1;
        while (i < position) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null)
            System.exit(3);
        Node temp = head;
        head = head.next;
        temp = null;
    }

    public void deleteFromEnd() {
        if (head == null)
            System.exit(4);
        Node temp = head, previousNode = null;
        while (temp.next != null) {
            previousNode = temp;
            temp = temp.next;
        }
        if (temp == head)
            head = null;
        else
            previousNode.next = null;
        temp = null;
    }

    public void deleteFromPosition(int position) {
        if (head == null)
            System.exit(5);
        int i = 1;
        Node temp = head, nextNode;
        while (i < position - 1) {
            temp = temp.next;
            i++;
        }
        nextNode = temp.next;
        temp.next = nextNode.next;
        nextNode = null;
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

    public void reverseList() {
        Node currentNode, previousNode, nextNode;
        currentNode = head;
        previousNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        // l1.insertAtBeginning(2);
        // l1.insertAtBeginning(1);
        // l1.insertAtLast(4);
        // l1.insertAtPosition(3, 2);
        // l1.displayList();
        // l1.deleteFromBeginning();
        // l1.deleteFromPosition(2);
        // l1.deleteFromEnd();
        // l1.displayList();
        // output 2

        l1.insertAtBeginning(1);
        l1.insertAtBeginning(2);
        l1.insertAtBeginning(3);
        l1.insertAtBeginning(4);
        l1.insertAtBeginning(5);
        l1.displayList();
        l1.reverseList();
        l1.displayList();
    }
}
