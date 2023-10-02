package Tree.JAVA;

class LeftSideView
{
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        if(root==null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();

            for(int i=0; i<levelNum; i++){
                Node temp=queue.poll();
                //right
                if(i==0){
                    result.add(temp.data);
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
