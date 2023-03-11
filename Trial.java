import java.util.*;
public class Trial {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        BinaryTreeNode root=BinaryTreeNode.LevelwiseInput();
        BinaryTreeNode.replacesumwithgreaterNodes(root);
        BinaryTreeNode.printTree(root);
    }    
}
