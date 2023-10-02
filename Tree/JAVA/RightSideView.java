package Tree.JAVA;

class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize an empty list to hold the values of the rightmost node at each level
        List<Integer> result = new LinkedList<Integer>();
        // queue to hold nodes at each level
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null){
            return result;
        }
        // Add the root node to the queue
        queue.offer(root);
        // Iterate over the queue until it's empty
        while(!queue.isEmpty()){
            // Get the number of nodes at the current level
            int levelNum = queue.size();
            // Iterate over the number of nodes at the current level
            for(int i=0; i<levelNum; i++){
                // Holds the current node
                TreeNode temp=queue.poll();
                // If the current node is the last one in the level, add its value to the result list
                if(i==levelNum-1){
                    result.add(temp.val);
                }
                // If the left child of the current node is not null, add it to the queue
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                // If the right child of the current node is not null, add it to the queue
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }
}
