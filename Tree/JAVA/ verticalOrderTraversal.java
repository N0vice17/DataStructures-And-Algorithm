/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class pair
    {
        int r;
        int c;
        TreeNode y;
        pair(int r,int c,TreeNode y)
        {
            this.r=r;
            this.c=c;
            this.y=y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Map<Integer,List<Integer>> map=new TreeMap<>();
        PriorityQueue<pair> q=new PriorityQueue<>(
            (pair1,pair2)-> (pair1.r!=pair2.r)? pair1.r-pair2.r:pair1.y.val-pair2.y.val
            );
        q.offer(new pair(0,0,root));
        while(!q.isEmpty())
        {
            List<Integer> temp;
            int r=q.peek().r;
            int c=q.peek().c;
            TreeNode curr=q.peek().y;
            q.poll();
            if(map.containsKey(c))
            {
                temp=map.get(c);
                temp.add(curr.val);
                map.put(c,temp);
            }
            else
            {
                temp=new ArrayList<>();
                temp.add(curr.val);
                map.put(c,temp);
            }            
            if(curr.left!=null) q.offer(new pair(r+1,c-1,curr.left));
            if(curr.right!=null) q.offer(new pair(r+1,c+1,curr.right));
        }

        map.forEach((k,v)->{
            res.add(v);
        });
        return res;

    }
}