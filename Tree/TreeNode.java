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
}
