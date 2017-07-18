package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qianle on 7/17/17.
 */
public class Binary_Tree_Path {

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return list;

        helper(list, root, "" + root.val);
        return list;
    }

    private void helper(ArrayList<String> list, TreeNode node, String str) {
        if (node.left == null && node.right == null) {
            list.add(str);
            return;
        }
        if (node.left == null) {
            helper(list, node.right, str + "->" + node.right.val);
        } else if (node.right == null) {
            helper(list, node.left, str + "->" + node.left.val);
        } else {
            helper(list, node.left, str + "->" + node.left.val);
            helper(list, node.right, str + "->" + node.right.val);
        }
        return;
    }
}
