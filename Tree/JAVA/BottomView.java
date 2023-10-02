package Tree.JAVA;

class BottomView {
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root) {
        // ArrayList to store the values of the nodes in the top view
        ArrayList<Integer> result = new ArrayList<>();
        // TreeMap to store the nodes, where the keys are the HDs and the values are the nodes
        // TreeMap will automatically sort the keys in ascending order
        Map<Integer, Node> map = new TreeMap<>();
        // Queue to store the Pair objects during the level-order traversal
        Queue<Pair> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        // Add the root and its HD to the queue
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int hd = pair.hd;

            map.put(hd, node);

            // Add the left child and its HD to the queue
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Add the right child and its HD to the queue
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Iterate through the map and add the values of the nodes to the ArrayList in order of the keys
        for (Node n : map.values()) {
            result.add(n.data);
        }

        // Return the ArrayList containing the values of the nodes in the top view
        return result;

    }

}
