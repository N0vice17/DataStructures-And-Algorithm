import java.util.*;
public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode(int Data) {
        this.data = Data;
    }

    // -----------------------------------------------------
    public static void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("Left" + " " + root.left.data + ",");
        }
        if (root.right != null) {
            System.out.print("Right" + " " + root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    // -----------------------------------------------------------------------------------
    public static BinaryTreeNode TakeInput(boolean isRoot, int parentdata, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter the Root Data");
        } else {
            if (isLeft) {
                System.out.println("Enter the left data of" + " " + parentdata);
            } else {
                System.out.println("Enter the right data of" + " " + parentdata);
            }
        }
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(data);
        BinaryTreeNode left = TakeInput(false, data, true);
        BinaryTreeNode right = TakeInput(false, data, false);
        root.left = left;
        root.right = right;
        return root;
    }

    // --------------------------------------------------------
    public static int Nodes(BinaryTreeNode root) {
        int count = 1;
        if (root == null) {
            return 0;
        }
        int leftnode = Nodes(root.left);
        int rightnode = Nodes(root.right);
        return count + leftnode + rightnode;
    }

    // ----------------------------------------------------------
    public static void Preorderprint(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        Preorderprint(root.left);
        Preorderprint(root.right);
    }

    // ---------------------------------------------------------
    public static void inorderprint(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inorderprint(root.left);
        System.out.print(root.data + " ");
        inorderprint(root.right);
    }

    // ---------------------------------------------------------
    public static int largest(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = largest(root.left);
        int right = largest(root.right);
        return Math.max(root.data, Math.max(left, right));
    }

    // ----------------------------------------------------------
    public static int leafnodes(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = leafnodes(root.left);
        int right = leafnodes(root.right);
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return left + right;
        }
    }

    // -------------------------------------------------------------
    public static void nodesAtdepth(BinaryTreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        nodesAtdepth(root.left, k - 1);
        nodesAtdepth(root.right, k - 1);
    }

    // ----------------------------------------------------------------
    public static void nodeswithoutsibling(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
            nodeswithoutsibling(root.left);
        }
        if (root.right != null && root.left == null) {
            System.out.print(root.right.data + " ");
            nodeswithoutsibling(root.right);
        }
        if (root.left != null && root.left != null) {
            nodeswithoutsibling(root.left);
            nodeswithoutsibling(root.right);
        }
    }

    // ------------------------------------------------------------
    public static BinaryTreeNode removeleaf(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeleaf(root.left);
        root.right = removeleaf(root.right);
        return root;
    }

    // ----------------------------------------------------------
    public static void MirrorTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode root1;
        root1 = root.left;
        root.left = root.right;
        root.right = root1;
        MirrorTree(root.left);
        MirrorTree(root.right);
    }

    // -----------------------------------------------------------
    public static int height(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static boolean balancedtree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        if (Math.abs(leftheight - rightheight) > 1) {
            return false;
        }
        boolean left = balancedtree(root.left);
        boolean right = balancedtree(root.right);
        return left && right;
    }

    // ------------------------------------------------------------
    public static int heightcombined(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = heightcombined(root.left);
        int right = heightcombined(root.right);
        return 1 + Math.max(left, right);
    }

    public static int dia(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dia(root.left);
        int right = dia(root.right);
        if (root.left != null) {
            return 1 + left;
        }
        if (root.right != null) {
            return 1 + right;
        }
        return left + right;
    }

    public static int diameter(BinaryTreeNode root) {
        return Math.max(heightcombined(root.left) + heightcombined(root.right),
                Math.max(dia(root.left), dia(root.right))) + 1;
    }

    // ---------------------------------------------------------------------------------------------------------------------
    public static BinaryTreeNode LevelwiseInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root data");
        int rootdata = input.nextInt();
        BinaryTreeNode root = new BinaryTreeNode(rootdata);
        Queue<BinaryTreeNode> set1 = new LinkedList<>();
        set1.add(root);
        while (!set1.isEmpty()) {
            BinaryTreeNode front = set1.poll();
            System.out.println("Enter the left data of " + front.data);
            int leftdata = input.nextInt();
            if (leftdata != -1) {
                BinaryTreeNode left = new BinaryTreeNode(leftdata);
                set1.add(left);
                front.left = left;
            }
            System.out.println("Enter the right data of " + front.data);
            int rightdata = input.nextInt();
            if (rightdata != -1) {
                BinaryTreeNode right = new BinaryTreeNode(rightdata);
                set1.add(right);
                front.right = right;
            }
        }
        input.close();
        return root;
    }

    // --------------------------------------------------------------------------------------------
    public static void printlevewise(BinaryTreeNode root) {
        Queue<BinaryTreeNode> set1 = new LinkedList<>();
        set1.add(root);
        if (root == null) {
            return;
        }
        while (!set1.isEmpty()) {
            BinaryTreeNode temp = set1.poll();
            if (temp.left == null && temp.right == null) {
                System.out.println(temp.data + ":Left:-1,Right:-1");
            } else if (temp.left == null && temp.right != null) {
                System.out.println(temp.data + ":Left:-1," + "Right:" + temp.right.data);
                set1.add(temp.right);
            } else if (temp.right == null && temp.left != null) {
                System.out.println(temp.data + ":" + "Left:" + temp.left.data + ",Right:-1");
                set1.add(temp.left);
            } else {
                System.out.println(temp.data + ":" + "Left:" + temp.left.data + "," + "Right:" + temp.right.data);
                set1.add(temp.left);
                set1.add(temp.right);
            }
        }
    }

    // ---------------------------------------------------------------------------------------------------
    public static void printlevelwisebetter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> set1 = new LinkedList<>();
        set1.add(root);
        while (true) {
            int count = set1.size();
            if (count == 0) {
                break;
            }
            while (count > 0) {
                BinaryTreeNode temp = set1.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    set1.add(temp.left);
                }
                if (temp.right != null) {
                    set1.add(temp.right);
                }
                count--;
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------
    public static void printuptosum(BinaryTreeNode root, int k, String str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && k == root.data) {
            System.out.println(str + root.data);
            return;
        }
        str = str + root.data + " ";
        printuptosum(root.left, k - root.data, str);
        printuptosum(root.right, k - root.data, str);
    }

    // --------------------------------------------------------------------------
    public static void NodeAtdistanceK(BinaryTreeNode root, int k, int element) {
        int x = print1(root, k, element);
    }

    public static int print1(BinaryTreeNode root, int k, int element) {
        if (root == null) {
            return -1;
        }
        if (root.data == element) {
            NodeAtdepthK(root, k);
            return 0;
        }
        int ld = print1(root.left, k, element);
        if (ld == -1) {
            int rd = print1(root.right, k, element);
            if (rd == -1) {
                return -1;
            } else if (rd + 1 == k) {
                System.out.println(root.data + " ");
                return k;
            } else {
                NodeAtdepthK(root.left, k - rd - 2);
                return rd + 1;
            }
        } else {
            if (ld + 1 == k) {
                NodeAtdepthK(root, k);
                return k;
            } else {
                NodeAtdepthK(root.right, k - ld - 2);
                return ld + 1;
            }
        }
    }

    public static void NodeAtdepthK(BinaryTreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data + " ");
            return;
        }
        NodeAtdepthK(root.left, k - 1);
        NodeAtdepthK(root.right, k - 1);
    }

    // -------------------------------------------------------------------------------------------------
    public static BinaryTreeNode helper(int[] pre, int[] in, int prestart, int prend, int instart, int inend) {
        if (prestart > prend) {
            return null;
        }
        int rootdata = pre[prestart];
        BinaryTreeNode root = new BinaryTreeNode(rootdata);
        int rootindex = -1;
        for (int i = instart; i <= inend; i++) {
            if (in[i] == rootdata) {
                rootindex = i;
                break;
            }
        }
        // considering that root is always present in the inorder array
        int preleftstart = prestart + 1;
        int prerightend = prend;
        int inleftstart = instart;
        int inleftend = rootindex - 1;
        int inrightstart = rootindex + 1;
        int inrightend = inend;
        int preleftend = preleftstart + (inleftend - inleftstart + 1) - 1;
        int prerightstart = preleftend + 1;
        BinaryTreeNode left = helper(pre, in, preleftstart, preleftend, inleftstart, inleftend);
        BinaryTreeNode right = helper(pre, in, prerightstart, prerightend, inrightstart, inrightend);
        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode createinorderandpre(int[] pre, int[] in) {
        BinaryTreeNode root = helper(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    // --------------------------------------------------------------------------------------------------
    public static BinaryTreeNode helper1(int[] post, int[] in, int poststart, int postend, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        int rootdata = post[postend];
        BinaryTreeNode root = new BinaryTreeNode(rootdata);
        int rootindex = -1;
        for (int i = instart; i <= inend; i++) {
            if (in[i] == rootdata) {
                rootindex = i;
                break;
            }
        }
        // considering that root is always present in the binarytree
        int postleftstart = poststart;
        int postrightend = postend - 1;
        int inleftstart = instart;
        int inleftend = rootindex - 1;
        int inrightstart = rootindex + 1;
        int inrightend = inend;
        int postleftend = postleftstart + (inleftend - inleftstart + 1) - 1;
        int postrightstart = postleftend + 1;
        BinaryTreeNode left = helper1(post, in, postleftstart, postleftend, inleftstart, inleftend);
        BinaryTreeNode right = helper1(post, in, postrightstart, postrightend, inrightstart, inrightend);
        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode createinorderandpost(int[] post, int[] in) {
        BinaryTreeNode root = helper1(post, in, 0, post.length - 1, 0, in.length - 1);
        return root;
    }

    // --------------------------------------------------------------------------------------------------------
    // Here starts the binary search tree
    public static boolean checkBST(BinaryTreeNode root) {
        if(root==null){
            return true;
        }
        int left=max(root.left);
        if(root.data<=left){
            return false;
        }
        int right=min(root.right);
        if(root.data>right){
            return false;
        }
        boolean isleft=checkBST(root.left);
        boolean isright=checkBST(root.right);
        return isleft&&isright;
    }
    public static int max(BinaryTreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int a=max(root.left);
        int b=max(root.right);
        return Math.max(root.data,Math.max(a,b));
    }
    public static int min(BinaryTreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int a=min(root.left);
        int b=min(root.right);
        return Math.min(root.data,Math.min(a,b));
    }
    //----------------------------------------------------------------------------------------------------------
    public static boolean BSTsearch(BinaryTreeNode root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        if (x < root.data) {
            return BSTsearch(root.left, x);
        } else {
            return BSTsearch(root.right, x);
        }
    }
    //----------------------------------------------------------------------------------------------------------
    public static void printbetweenk1andk2(BinaryTreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data > k1) {
            printbetweenk1andk2(root.right, k1, k2);
        }
        if (root.data >= k1 && root.data <= k2) {
            System.out.println(root.data + " ");
        }
        if (root.data < k2) {
            printbetweenk1andk2(root.left, k1, k2);
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    public static BinaryTreeNode helper(int start,int end,int[]arr){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        BinaryTreeNode root=new BinaryTreeNode(arr[mid]);
        BinaryTreeNode left=helper(start,mid-1,arr);
        BinaryTreeNode right=helper(mid+1,end,arr);
        root.left=left;
        root.right=right;
        return root;
    }
    public static BinaryTreeNode constructBST(int[]arr){
        BinaryTreeNode root=helper(0, arr.length-1, arr);
        return root;
    }
    //------------------------------------------------------------------------------------------------------------
    public static void BSTprint(BinaryTreeNode root){
        if(root==null){
            return;
        }
        BSTprint(root.left);
        System.out.print(root.data+" ");
        BSTprint(root.right);
    }
    //--------------------------------------------------------------------------------------------------------------
    public static Node realhead=new Node(-1);
    public static Node ptr=realhead;
    public static Node head(BinaryTreeNode root) {
    	createlist(realhead,root);
    	return realhead.next;
    }
    public static void createlist(Node head,BinaryTreeNode root) {
    	if(root==null) {
    		return;
    	}
    	createlist(head, root.left);
    	Node temp=new Node(root.data);
    	ptr.next=temp;
    	ptr=ptr.next;
    	createlist(temp, root.right);
    }
    //---------------------------------------------------------------------------------------------------
    public static ArrayList<Integer> RoottoData(BinaryTreeNode root,int x){
        if(root==null){
            return null;
        }
        if(root.data==x){
            ArrayList<Integer> arr=new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        ArrayList<Integer>left=RoottoData(root.left, x);
        if(left!=null){
            left.add(root.data);
            return left;
        }
        ArrayList<Integer>right=RoottoData(root.right, x);
        if(right!=null){
            right.add(root.data);
            return right;
        }
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(-1);
        return arr;
    }
    //--------------------------------------------------------------------------------------------------
    public static int LargestBST(BinaryTreeNode root) {
    	//Given a BinaryTree you have to print the height of the largest BST in the binaryTree
    	if(checkBST(root)) {
    		return height(root);
    	}
    	int left=LargestBST(root.left);
    	int right=LargestBST(root.right);
    	return Math.max(left,right);
    }
    //---------------------------------------------------------------------------------------------------
    public static void replacesumwithgreaterNodes(BinaryTreeNode root) {
    	//You have been given a BST you have to replace the nodes with the sum of values greater or equal to that node
    	if(root==null) {
    		return;
    	}
    	replacesumwithgreaterNodes(root.left);
    	int sum=maxsum(root.right);
    	root.data=sum+root.data;
    	replacesumwithgreaterNodes(root.right);
    }
    public static int maxsum(BinaryTreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	int sum=0;
    	sum=sum+root.data;
    	int left=maxsum(root.left);
    	int right=maxsum(root.right);
    	return sum;
    }
}
