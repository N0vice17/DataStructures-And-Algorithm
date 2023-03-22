import Tree.*;
import java.util.*;
import LinkedList.*;
public class Trial {
    public static void main(String[]args){
        TreeNode<Integer>root1=TreeNode.LevelwiseInput();
        TreeNode<Integer>root2=TreeNode.LevelwiseInput();
        System.out.println(TreeNode.checkidentical(root1, root2));
    }    
}
