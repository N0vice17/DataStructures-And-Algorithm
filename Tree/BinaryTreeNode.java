package Tree;
import java.util.*;
import LinkedList.*;
public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<Integer> left;
    public BinaryTreeNode<Integer> right;
    public BinaryTreeNode(T Data) {
        this.data = Data;
    }

    // -----------------------------------------------------
    public static void printTree(BinaryTreeNode<Integer> root) {
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
    public static BinaryTreeNode<Integer> TakeInput(boolean isRoot, int parentdata, boolean isLeft) {
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
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        BinaryTreeNode<Integer> left = TakeInput(false, data, true);
        BinaryTreeNode<Integer> right = TakeInput(false, data, false);
        root.left = left;
        root.right = right;
        return root;
    }

    // --------------------------------------------------------
    public static int Nodes(BinaryTreeNode<Integer> root) {
        int count = 1;
        if (root == null) {
            return 0;
        }
        int leftnode = Nodes(root.left);
        int rightnode = Nodes(root.right);
        return count + leftnode + rightnode;
    }

    // ----------------------------------------------------------
    public static void Preorderprint(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        Preorderprint(root.left);
        Preorderprint(root.right);
    }

    // ---------------------------------------------------------
    public static void inorderprint(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorderprint(root.left);
        System.out.print(root.data + " ");
        inorderprint(root.right);
    }

    // ---------------------------------------------------------
    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = largest(root.left);
        int right = largest(root.right);
        return Math.max(root.data, Math.max(left, right));
    }

    // ----------------------------------------------------------
    public static int leafnodes(BinaryTreeNode<Integer> root) {
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
    public static void nodesAtdepth(BinaryTreeNode<Integer> root, int k) {
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
    public static void nodeswithoutsibling(BinaryTreeNode<Integer> root) {
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
    public static BinaryTreeNode<Integer> removeleaf(BinaryTreeNode<Integer> root) {
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
    public static void MirrorTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode<Integer> root1;
        root1 = root.left;
        root.left = root.right;
        root.right = root1;
        MirrorTree(root.left);
        MirrorTree(root.right);
    }

    // -----------------------------------------------------------
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static boolean balancedtree(BinaryTreeNode<Integer> root) {
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
    public static int heightcombined(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = heightcombined(root.left);
        int right = heightcombined(root.right);
        return 1 + Math.max(left, right);
    }

    public static int dia(BinaryTreeNode<Integer> root) {
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

    public static int diameter(BinaryTreeNode<Integer> root) {
        return Math.max(heightcombined(root.left) + heightcombined(root.right),
                Math.max(dia(root.left), dia(root.right))) + 1;
    }

    // ---------------------------------------------------------------------------------------------------------------------
    public static BinaryTreeNode<Integer> LevelwiseInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root data");
        int rootdata = input.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        Queue<BinaryTreeNode<Integer>> set1 = new LinkedList<>();
        set1.add(root);
        while (!set1.isEmpty()) {
            BinaryTreeNode<Integer> front = set1.poll();
            System.out.println("Enter the left data of " + front.data);
            int leftdata = input.nextInt();
            if (leftdata != -1) {
                BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftdata);
                set1.add(left);
                front.left = left;
            }
            System.out.println("Enter the right data of " + front.data);
            int rightdata = input.nextInt();
            if (rightdata != -1) {
                BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightdata);
                set1.add(right);
                front.right = right;
            }
        }
        input.close();
        return root;
    }

    // --------------------------------------------------------------------------------------------
    public static void printlevewise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> set1 = new LinkedList<>();
        set1.add(root);
        if (root == null) {
            return;
        }
        while (!set1.isEmpty()) {
            BinaryTreeNode<Integer> temp = set1.poll();
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
    public static void printlevelwisebetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> set1 = new LinkedList<>();
        set1.add(root);
        while (true) {
            int count = set1.size();
            if (count == 0) {
                break;
            }
            while (count > 0) {
                BinaryTreeNode<Integer> temp = set1.poll();
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
    public static void printuptosum(BinaryTreeNode<Integer> root, int k, String str) {
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
    public static void NodeAtdistanceK(BinaryTreeNode<Integer> root, int k, int element) {
        int x = print1(root, k, element);
    }

    public static int print1(BinaryTreeNode<Integer> root, int k, int element) {
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

    public static void NodeAtdepthK(BinaryTreeNode<Integer> root, int k) {
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
    public static BinaryTreeNode<Integer> helper(int[] pre, int[] in, int prestart, int prend, int instart, int inend) {
        if (prestart > prend) {
            return null;
        }
        int rootdata = pre[prestart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
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
        BinaryTreeNode<Integer> left = helper(pre, in, preleftstart, preleftend, inleftstart, inleftend);
        BinaryTreeNode<Integer> right = helper(pre, in, prerightstart, prerightend, inrightstart, inrightend);
        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode<Integer> createinorderandpre(int[] pre, int[] in) {
        BinaryTreeNode<Integer> root = helper(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    // --------------------------------------------------------------------------------------------------
    public static BinaryTreeNode<Integer> helper1(int[] post, int[] in, int poststart, int postend, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        int rootdata = post[postend];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
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
        BinaryTreeNode<Integer> left = helper1(post, in, postleftstart, postleftend, inleftstart, inleftend);
        BinaryTreeNode<Integer> right = helper1(post, in, postrightstart, postrightend, inrightstart, inrightend);
        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode<Integer> createinorderandpost(int[] post, int[] in) {
        BinaryTreeNode<Integer> root = helper1(post, in, 0, post.length - 1, 0, in.length - 1);
        return root;
    }

    // --------------------------------------------------------------------------------------------------------
    // Here starts the binary search tree
    public static boolean checkBST(BinaryTreeNode<Integer> root) {
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
    public static int max(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int a=max(root.left);
        int b=max(root.right);
        return Math.max(root.data,Math.max(a,b));
    }
    public static int min(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int a=min(root.left);
        int b=min(root.right);
        return Math.min(root.data,Math.min(a,b));
    }
    //----------------------------------------------------------------------------------------------------------
    public static boolean BSTsearch(BinaryTreeNode<Integer> root, int x) {
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
    public static void printbetweenk1andk2(BinaryTreeNode<Integer> root, int k1, int k2) {
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
    public static BinaryTreeNode<Integer> helper(int start,int end,int[]arr){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[mid]);
        BinaryTreeNode<Integer> left=helper(start,mid-1,arr);
        BinaryTreeNode<Integer> right=helper(mid+1,end,arr);
        root.left=left;
        root.right=right;
        return root;
    }
    public static BinaryTreeNode<Integer> constructBST(int[]arr){
        BinaryTreeNode<Integer> root=helper(0, arr.length-1, arr);
        return root;
    }
    //------------------------------------------------------------------------------------------------------------
    public static void BSTprint(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        BSTprint(root.left);
        System.out.print(root.data+" ");
        BSTprint(root.right);
    }
    //--------------------------------------------------------------------------------------------------------------
    public static LinkedListNode<Integer> realhead=new LinkedListNode<Integer>(-1);
    public static LinkedListNode<Integer> ptr=realhead;
    public static LinkedListNode<Integer> head(BinaryTreeNode<Integer> root) {
    	createlist(realhead,root);
    	return realhead.next;
    }
    public static void createlist(LinkedListNode<Integer> head, BinaryTreeNode<Integer> root) {
    	if(root==null) {
    		return;
    	}
    	createlist(head, root.left);
        LinkedListNode<Integer> temp=new LinkedListNode<Integer>(root.data);
    	ptr.next=temp;
    	ptr=ptr.next;
    	createlist(temp, root.right);
    }
    //---------------------------------------------------------------------------------------------------
    public static ArrayList<Integer> RoottoData(BinaryTreeNode<Integer> root,int x){
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
    public static int LargestBST(BinaryTreeNode<Integer> root) {
    	//Given a BinaryTree you have to print the height of the largest Tree.BST in the binaryTree
    	if(checkBST(root)) {
    		return height(root);
    	}
    	int left=LargestBST(root.left);
    	int right=LargestBST(root.right);
    	return Math.max(left,right);
    }
    //---------------------------------------------------------------------------------------------------
    public static void replacesumwithgreaterNodes(BinaryTreeNode<Integer> root) {
    	//You have been given a Tree.BST you have to replace the nodes with the sum of values greater or equal to that node
    	if(root==null) {
            return;
        }
    	int ans=replace(root,0);
    }
    public static int replace(BinaryTreeNode<Integer> root,int sum){
        if(root==null){
            return 0;
        }
        int right=replace(root.right,sum);
        int rootdata=root.data;
        root.data=root.data+right+sum;
        int left=replace(root.left,root.data);
        return rootdata+left+right;
    }
    //-----------------------------------------------------------------------------------------------------
    public static ArrayList<LinkedListNode<Integer>> levelwiselist(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        ArrayList<LinkedListNode<Integer>> store=new ArrayList<>();
        Queue<BinaryTreeNode<Integer>>set1=new LinkedList<>();
        set1.add(root);
        BinaryTreeNode<Integer> dummy=new BinaryTreeNode<Integer>(-1);
        set1.add(dummy);
        while(true){
            int size=set1.size();
            int num=set1.peek().data;
            if(size==1&&num==-1){
                break;
            }
            BinaryTreeNode<Integer>parsed=set1.poll();
            LinkedListNode<Integer>head=new LinkedListNode<Integer>(parsed.data);
            store.add(head);
            if(parsed.left!=null){
                set1.add(parsed.left);
            }
            if(parsed.right!=null){
                set1.add(parsed.right);
            }
            LinkedListNode<Integer>temp=head;
            size=size-1;
            while(size>0){
                BinaryTreeNode<Integer>parsed1=set1.poll();
                if(parsed1.data!=-1){
                    LinkedListNode<Integer>temp1=new LinkedListNode<Integer>(parsed1.data);
                    temp.next=temp1;
                    temp=temp1;
                    temp.next=null;
                    if(parsed1.left!=null){
                        set1.add(parsed1.left);
                    }
                    if(parsed1.right!=null){
                        set1.add(parsed1.right);
                    }
                }
                size=size-1;
            }
            set1.add(dummy);
        }
        return store;
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void pairsum(BinaryTreeNode<Integer>root,int sum){
            ArrayList<Integer>value=new ArrayList<>();
            helper(root,value);
            Collections.sort(value);
            for(int i=0;i<value.size()-1;i++){
                for(int j=i+1;j<value.size();j++){
                    if(value.get(i)+value.get(j)==sum){
                        System.out.println(Math.min(value.get(i),value.get(j))+" "+Math.max(value.get(i),value.get(j)));
                    }
                }
            }
//            System.out.println(value);
    }
    public static void helper(BinaryTreeNode<Integer>root,ArrayList<Integer>arr){
        if(root==null){
            return ;
        }
        helper(root.left,arr);
        arr.add(root.data);
        helper(root.right,arr);
    }
    //-------------------------------------------------------------------------------------------------------------------
    public static int LCA(BinaryTreeNode<Integer>root,int val1,int val2){
        if(root==null){
            return -1;
        }
        if(val1>root.data&&val2>root.data){
            return LCA(root.right,val1,val2);
        }
        if(val1<root.data&&val2<root.data){
            return LCA(root.left,val1,val2);
        }
        return root.data;
    }
    //------------------------------------------------------------------------------------------------------------------
}
