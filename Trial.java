import Tree.*;
import java.util.*;
import LinkedList.*;
public class Trial {
    public static void main(String[]args){
        TreeNode<Integer>root=TreeNode.LevelwiseInput();
        TreeNode.replacenodwithdepth(root);
        TreeNode.printlevelwisecustomized(root);
    }    
}
