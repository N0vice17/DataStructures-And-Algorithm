import Tree.*;
import java.util.*;
import LinkedList.*;
public class Trial {
    public static void main(String[]args){
        TreeNode<Integer>root=TreeNode.LevelwiseInput();
        TreeNode.printlevelwisecustomized(root);
        System.out.println(TreeNode.height(root));
    }    
}
