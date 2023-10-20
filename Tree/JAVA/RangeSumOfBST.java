  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 
class Solution {
    ArrayList<Integer> traverse(TreeNode root,int low,int high,ArrayList<Integer> sum) {
        if (root == null)
        return sum;
        
        ArrayList<Integer> temp1=traverse(root.left,low,high,sum);

        ArrayList<Integer> temp2=traverse(root.right,low,high,sum);
        
        sum.add(root.val);
        return sum;
    }
    int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer> r=new ArrayList<>();
        int sum=0;
        ArrayList<Integer> res=traverse(root,low,high,r);
        for(int i:res) {
            if(i>=low && i<=high)
            sum+=i;
        }
        return sum;
    }
}