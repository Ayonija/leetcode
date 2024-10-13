/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null; // Handle empty graph

        Map<Node, Node> visited = new HashMap<>(); // Map to keep track of cloned nodes
        return clone(node, visited); // Start cloning from the given node
    }

    private Node clone(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node); // Return the cloned node if it already exists
        }

        // Create a new node with the same value as the original
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode); // Store the cloned node in the map

        // Recursively clone all neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(clone(neighbor, visited)); // Add cloned neighbors to the cloned node
        }

        return cloneNode; // Return the cloned node
    }
}