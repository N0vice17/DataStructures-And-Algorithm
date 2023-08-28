package Tree;
import java.util.*;
public class TreeNode<T> {
    private T data;
    private ArrayList<TreeNode<T>> children;
    public TreeNode(T data){
        this.data=data;
        this.children=new ArrayList<TreeNode<T>>();
    }
    public static int getdata(TreeNode<Integer>Root){
            return Root.data;
    }
    public static void AddChildren(TreeNode<Integer>Parent,TreeNode<Integer>Children){
        Parent.children.add(Children);
    }
    public static void PrintChildren(TreeNode<Integer>Root){
        System.out.println(Root.children);
    }
    public static ArrayList<TreeNode<Integer>> GetChildren(TreeNode<Integer>Root){
        return Root.children;
    }
    public static void printTree1(TreeNode<Integer>Root){
        //Preorder way to print the tree but it is not the best way
        if(Root==null){
            //This is the special case not the base case, the base case in handled in the for loop
            return;
        }
        System.out.print(Root.data+" ");
        for(int i=0;i<Root.children.size();i++){
            TreeNode<Integer>child=Root.children.get(i);
            printTree1(child);
        }
    }
    public static void printTreebetter(TreeNode<Integer>Root){
        if(Root==null){
            return;
        }
        System.out.print(Root.data+":");
        for(int i=0;i<Root.children.size();i++){
            System.out.print(Root.children.get(i).data+" ");
        }
        System.out.println( );
        for(int i=0;i<Root.children.size();i++){
            TreeNode<Integer>child=Root.children.get(i);
            printTreebetter(child);
        }
    }
    public static int NodeinTree(TreeNode<Integer>root){
        int count=1;
        for(int i=0;i<root.children.size();i++){
            int childcount=NodeinTree(root.children.get(i));
            count=count+childcount;
        }
        return count;
    }
    public static int SumofNodes(TreeNode<Integer>root){
        int sum=root.data;
        for(int i=0;i<root.children.size();i++){
            int sumchild=SumofNodes(root.children.get(i));
            sum=sum+sumchild;
        }
        return sum;
    }
    public static TreeNode<Integer> LevelwiseInput(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Root Data:");
        int rootdata=input.nextInt();
        if(rootdata==-1){
            return null;
        }
        TreeNode<Integer>root=new TreeNode<>(rootdata);
        Queue<TreeNode<Integer>>set1=new LinkedList<>();
        set1.add(root);
            while(!set1.isEmpty()){
                TreeNode<Integer>temp=set1.poll();
                ArrayList<TreeNode<Integer>>store=new ArrayList<>();
                System.out.println("Enter the Children data of:"+temp.data);
                while(true){
                    int data=input.nextInt();
                    if(data==-1){
                        break;
                    }
                    TreeNode<Integer>child=new TreeNode<>(data);
                    set1.add(child);
                    store.add(child);
                    System.out.println("Enter the Children data of:"+temp.data);
                }
                temp.children=store;
            }
        return root;
    }
    public static void printlevelwiseoriginal(TreeNode<Integer>root){
        if(root==null){
            return;
        }
        Queue<TreeNode<Integer>>set1=new LinkedList<>();
        set1.add(root);
        while(!set1.isEmpty()){
            int n=set1.size();
            while(n>0){
                TreeNode<Integer>temp=set1.poll();
                System.out.print(temp.data+" ");
                for(int i=0;i<temp.children.size();i++){
                    set1.add(temp.children.get(i));
                }
                n--;
            }
            System.out.println();
        }
    }
    public static void printlevelwisecustomized(TreeNode<Integer>root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> set1 = new LinkedList<>();
        set1.add(root);
        while (!set1.isEmpty()) {
            TreeNode<Integer> temp = set1.poll();
            System.out.print("Root:" + temp.data + "->");
            for (int i = 0; i < temp.children.size(); i++) {
                System.out.print(temp.children.get(i).data + " ");
                set1.add(temp.children.get(i));
            }
            System.out.println();
        }
    }
    public static int NodesGreater(TreeNode<Integer>root,int num){
        if(root==null){
            return 0;
        }
        int count1=0;
        if(root.data>num){
            count1++;
        }
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer>child=root.children.get(i);
            count1=count1+NodesGreater(child,num);
        }
        return count1;
    }
    public static int height(TreeNode<Integer>root){
        int height=0,temp=0;
        if(root==null){
            return 0;
        }
        if(root.children.size()==0){
            return 1;
        }
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer>child=root.children.get(i);
            temp=height(child);
            height=Math.max(height,temp);
        }
        return height+1;
    }
    public static void post_order(TreeNode<Integer>root){
        if(root==null){
            return;
        }
        for(int i=0;i<root.children.size();i++){
            post_order(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }
    public static boolean Ispresent=true;
    public static boolean ispresent(TreeNode<Integer>root,int num){
        if(root==null){
            return false;
        }
        if(root.data==num){
            Ispresent=true;
            return Ispresent;
        }
        for(int i=0;i<root.children.size();i++){
            Ispresent=ispresent(root.children.get(i),num);
        }
        return Ispresent;
    }
    public static TreeNode<Integer> Nodewithmaxsum(TreeNode<Integer>root){
        if(root==null){
            return null;
        }
        int sum=0;
        TreeNode<Integer>temp1=root;
        Queue<TreeNode<Integer>>set1=new LinkedList<>();
        set1.add(root);
        while(!set1.isEmpty()){
            TreeNode<Integer>temp=set1.poll();
            int tempsum=temp.data;
            for(int i=0;i<temp.children.size();i++){
                tempsum=tempsum+temp.children.get(i).data;
                set1.add(temp.children.get(i));
            }
            if(tempsum>sum){
                sum=tempsum;
                temp1=temp;
            }
        }
        return temp1;
    }
    public static int leafNodes(TreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int count=0;
        if(root.children.size()==0){
            count++;
        }
        for(int i=0;i<root.children.size();i++){
            count=count+leafNodes(root.children.get(i));
        }
        return count;
    }
    public static boolean checkidentical(TreeNode<Integer>root1,TreeNode<Integer>root2){
        if(root1==null||root2==null){
            return false;
        }
        boolean check=false;
        Queue<TreeNode<Integer>>tree1=new LinkedList<>();
        Queue<TreeNode<Integer>>tree2=new LinkedList<>();
        tree1.add(root1);
        tree2.add(root2);
        while(!tree1.isEmpty()||!tree2.isEmpty()){
            TreeNode<Integer>temp1=tree1.poll();
            TreeNode<Integer>temp2=tree2.poll();
            if(temp1.data==temp2.data&&temp1.children.size()==temp2.children.size()){
                check=true;
                for(int i=0;i<temp1.children.size();i++){
                    tree1.add(temp1.children.get(i));
                    tree2.add(temp2.children.get(i));
                }
            }
            else{
                check=false;
                break;
            }
        }
        if(tree1.isEmpty()||tree2.isEmpty()){
            check=true;
        }
        else{
            check=false;
        }
        return check;
    }
    public static TreeNode<Integer> nextbig(TreeNode<Integer>root,int num){
        if(root==null){
            return null;
        }
        ArrayList<TreeNode<Integer>>arr=new ArrayList<>();
        Queue<TreeNode<Integer>>set1=new LinkedList<>();
        set1.add(root);
        while(!set1.isEmpty()){
            TreeNode<Integer>temp=set1.poll();
            if(temp.data>num){
                arr.add(temp);
            }
            for(int i=0;i<temp.children.size();i++){
                set1.add(temp.children.get(i));
            }
        }
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).data<min){
                index=i;
                min=arr.get(i).data;
            }
        }
        if(arr.size()==0){
            return null;
        }
        return arr.get(index);
    }
    public static TreeNode<Integer> secondlargest(TreeNode<Integer>root){
        if(root==null){
            return null;
        }
        ArrayList<TreeNode<Integer>>arr=new ArrayList<>();
        Queue<TreeNode<Integer>>set1=new LinkedList<>();
        set1.add(root);
        while(!set1.isEmpty()){
            TreeNode<Integer>temp=set1.poll();
            arr.add(temp);
            for(int i=0;i<temp.children.size();i++){
                set1.add(temp.children.get(i));
            }
        }
        int index1=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            max=Math.max(max,arr.get(i).data);
        }
        int max1=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).data>max&&max!=arr.get(i).data){
                max1=arr.get(i).data;
                index1=i;
            }
        }
        if(max1==0){
            return null;
        }
        return arr.get(index1);
    }
    public static void replacenodwithdepth(TreeNode<Integer>root){
        if(root==null){
            return;
        }
        helper(root,0);
    }
    public static void helper(TreeNode<Integer>root,int level){
        if(root==null){
            return;
        }
        root.data=level;
        for(int i=0;i<root.children.size();i++){
            helper(root.children.get(i),level+1);
        }
    }
}
