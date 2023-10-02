package Tree.JAVA;

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // queue to hold nodes at each level
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // list to hold all levels
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        // Check if the root is null, if so, return an empty list
        if(root==null){
            return wrapList;
        }
        // Add the root node to the queue
        queue.offer(root);
        // Iterate over the queue until it's empty
        while(!queue.isEmpty()){
            // Get the number of nodes at the current level
            int levelNum = queue.size();
            // Create a sublist to hold the values of the nodes at the current level
            List<Integer> subList = new LinkedList<Integer>();
            // Iterate over the number of nodes at the current level
            for(int i=0; i<levelNum; i++){
                // Holds the current node
                TreeNode temp=queue.poll();
                // Add the current node's value to the sublist
                subList.add(temp.val);
                // If the left child of the current node is not null, add it to the queue
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                // If the right child of the current node is not null, add it to the queue
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            // Add the sublist to the wrapList
            wrapList.add(subList);
        }
        return wrapList;
    }
}
