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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // Create a set for quick lookup of nodes to delete
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int value : to_delete) {
            toDeleteSet.add(value);
        }
        
        // List to hold the roots of the remaining trees
        List<TreeNode> remainingForest = new ArrayList<>();
        
        // Start the recursive deletion process
        if (deleteNodes(root, toDeleteSet, remainingForest) != null) {
            remainingForest.add(root);
        }
        
        return remainingForest;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> remainingForest) {
        if (node == null) {
            return null; // Base case: if node is null, return null
        }

        // Recursively delete nodes from left and right subtrees
        node.left = deleteNodes(node.left, toDeleteSet, remainingForest);
        node.right = deleteNodes(node.right, toDeleteSet, remainingForest);

        // Check if the current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // If it has left child, add it to the forest
            if (node.left != null) {
                remainingForest.add(node.left);
            }
            // If it has right child, add it to the forest
            if (node.right != null) {
                remainingForest.add(node.right);
            }
            // Return null since this node is deleted
            return null;
        }
        // Return the current node if it is not deleted
        return node;
    }

}