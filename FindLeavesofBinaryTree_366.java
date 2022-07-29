/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
Example:
Input: [1,2,3,4,5]

          1
         / \
        2   3
       / \
      4   5

Output: [[4,5,3],[2],[1]]
 Explanation:
1. Removing the leaves [4,5,3] would result in this tree:

          1
         /
        2
 2. Now removing the leaf [2] would result in this tree:
         1
 3. Now removing the leaf [1] would result in the empty tree:
          []
 */

import java.util.*;
public class FindLeavesofBinaryTree_366 {
    class TreeNode {
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> leaves;
        while(root.left!=null || root.right!=null){
            leaves = new ArrayList<>();
            findLeaves(root, leaves);
            ans.add(leaves);
        }
        leaves = new ArrayList<>();
        leaves.add(root.val);
        ans.add(leaves);
        return ans;
    }

    private boolean findLeaves(TreeNode node, List<Integer> leaves){
        if(node.left == null && node.right == null){
            leaves.add(node.val);
            return true;
        }
        if(node.left!=null){
            if(findLeaves(node.left,leaves))
                node.left = null;
        }

        if(node.right!=null){
            if(findLeaves(node.right, leaves))
                node.right = null;
        }
         return false;
    }

    private TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args){
        FindLeavesofBinaryTree_366 findLeavesofBinaryTree_366 = new FindLeavesofBinaryTree_366();

        TreeNode root = findLeavesofBinaryTree_366.createTree();
       findLeavesofBinaryTree_366.findLeaves(root);
    }
}
