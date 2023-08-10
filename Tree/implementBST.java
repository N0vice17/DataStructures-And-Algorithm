class Node {
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BST {
    private Node root = null;

    private void insertNode(Node root, int data) {
        if (data <= root.data) {
            if (root.left == null)
                root.left = new Node(data);
            else
                insertNode(root.left, data);
        } else {
            if (root.right == null)
                root.right = new Node(data);
            else
                insertNode(root.right, data);
        }
    }

    public void insert(int data) {
        if (root == null)
            root = new Node(data);
        else
            insertNode(root, data);
    }

    private boolean searchNode(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (data <= root.data)
            return searchNode(root.left, data);
        else
            return searchNode(root.right, data);
    }

    public boolean search(int data) {
        return searchNode(root, data);
    }
}

class Main {
    public static void main(String[] args) {
        BST t = new BST();
        t.insert(15);
        t.insert(10);
        t.insert(20);
        t.insert(25);
        t.insert(8);
        t.insert(12);
        System.out.println(t.search(15));
        System.out.println(t.search(31));
        System.out.println(t.search(20));
        System.out.println(t.search(7));
    }
}
