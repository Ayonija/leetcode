/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         while (root != null) {
            // If both p and q are smaller than root, LCA lies in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than root, LCA lies in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                // We have found the split point, i.e., the LCA
                return root;
            }
        }
        return null; // In case there is no LCA found (should not happen as per problem statement)
    }
}