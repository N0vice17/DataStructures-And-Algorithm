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

    private int calculateHeightBST(Node root) {
        if (root == null)
            return -1;
        return Math.max(calculateHeightBST(root.left), calculateHeightBST(root.right)) + 1;
    }

    public int findHeight() {
        return calculateHeightBST(root);
    }
}

class Main {
    public static void main(String[] args) {
        BST t = new BST();
        t.insert(5);
        t.insert(3);
        t.insert(8);
        t.insert(2);
        System.out.println(t.findHeight());
    }
}
