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
}
