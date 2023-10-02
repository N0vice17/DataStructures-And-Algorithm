public class BinaryTreeTraversals {
    static void preorder(TreeNode root) {
        if(root == null) return;

        // Pre-order traversal follows root-left-right path        
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(TreeNode root) {
        if(root == null) return;

        // In-order traversal follows left-root-right path
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static void postorder(TreeNode root) {
        if(root == null) return;

        // Post-order traversal follows left-right-root path
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
}

class TreeNode {
    public int data;
    public TreeNode left, right;
    
    public TreeNode() {}

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
