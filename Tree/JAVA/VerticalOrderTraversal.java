package Tree.JAVA;

class VerticalOrderTraversal
{
    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        // Base case
        if (root == null) {
            return result;
        }

        // Create a map and queue
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        // Assign horizontal distance as 0 for root
        // and enqueue it
        queue.add(new Pair(root, 0));

        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();

            Node node = temp.node;
            int hd = temp.hd;

            // Put the dequeued tree node to map
            // having key as horizontal distance. Every
            // time we find a node having same horizontal
            // distance we need to update the map
            if (!map.containsKey(hd)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.data);
                map.put(hd, list);
            } else {
                map.get(hd).add(node.data);
            }

            // If the dequeued node has a left child, add
            // it to the queue with a horizontal distance hd-1.
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // If the dequeued node has a right child, add
            // it to the queue with a horizontal distance
            // hd+1.
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Traverse the map and add nodes at
        // every horizontal distance (hd) to the result
        for (ArrayList<Integer> values : map.values()) {
            result.addAll(values);
        }
        return result;
    }