package Tree;
//All the functions here are of time complexity of O(logN) if the Tree.BST is balanced
// If the Tree.BST is not balanced then it can go up to O(N)
//N = height of the binary search tree.
public class BST {
    private static BinaryTreeNode<Integer> root;
    private static int size;
    public static boolean isPresent(int num){
        return isPresenthelper(root, num);
    }
    public static void insert(int num){
        root=inserthelper(root, num);
    }
    public static boolean delete(int num){
        BSTdeletereturn output=deletehelper(root,num);
        root=output.root;
        if(output.deleted){
            size--;
        }
        return output.deleted;
    }
    public static int size(){
        return size;
    } 
    public static void printTree(){
        printTreehelper(root);
    }
    private static BinaryTreeNode inserthelper(BinaryTreeNode<Integer> root,int data){
        if(root==null){
            BinaryTreeNode<Integer> newroot=new BinaryTreeNode<Integer>(data);
            return newroot;
        }
        if(data>root.data){
            root.right=inserthelper(root.right, data);
        }
        if(data<root.data){
            root.left=inserthelper(root.left, data);
        }
        return root;
    }
    private static void printTreehelper(BinaryTreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+":");
        if(root.left!=null){
            System.out.print("L"+root.left.data+",");
        }
        if(root.right!=null){
            System.out.print("R"+root.right.data+",");
        }
        System.out.println( );
        printTreehelper(root.left);
        printTreehelper(root.right);
    }
    private static boolean isPresenthelper(BinaryTreeNode<Integer> root,int num){
        if(root==null){
            return false;
        }
        if(root.data==num){
            return true;
        }
        if(num<root.data){
           return isPresenthelper(root.left, num);
        }
        else{
            return isPresenthelper(root.right, num);
        }
    }
    private static BSTdeletereturn deletehelper(BinaryTreeNode<Integer> root, int data){
       if(root==null) {
    	   return new BSTdeletereturn(null,false);
       }
       if(data>root.data) {
    	   BSTdeletereturn right=deletehelper(root.right, data);
    	   root.right=right.root;
    	   right.root=root;
    	   return right;
       }
       if(data<root.data) {
    	   BSTdeletereturn left=deletehelper(root.left, data);
    	   root.left=left.root;
    	   left.root=root;
    	   return left;
       }
       if(root.left==null&&root.right==null) {
    	   return new BSTdeletereturn(null, true);
       }
       if(root.left!=null&&root.right==null) {
    	   return new BSTdeletereturn(root.left, true);
       }
       if(root.right!=null&&root.left==null) {
    	   return new BSTdeletereturn(root.right, true);
       }
       int rightmin=minimum(root.right);
       root.data=rightmin;
       BSTdeletereturn newright=deletehelper(root.right, rightmin);
       root.right=newright.root;
       return new BSTdeletereturn(root,true);
    }
    private static int minimum(BinaryTreeNode<Integer> root) {
    	if(root==null) {
    		return Integer.MAX_VALUE;
    	}
    	int left=minimum(root.left);
    	int right=minimum(root.right);
    	return Math.min(root.data,Math.min(left, right));
    }
}
