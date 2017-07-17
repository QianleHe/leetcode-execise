package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by qianle on 7/16/17.
 */
public class Binary_Tree_Level_OrderTraversal {

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class tuple {
        public TreeNode node;
        public int level;
        public tuple(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<tuple> stack = new Stack<>();

        if (root != null) {
            stack.push(new tuple(root, 0));
        }

        while (!stack.isEmpty()) {
            tuple t = stack.pop();
            if (res.size() < t.level + 1) {
                res.add(new ArrayList<>());
            }
            res.get(t.level).add(t.node.val);
            if (t.node.right != null) {
                stack.push(new tuple(t.node.right, t.level + 1));
            }
            if (t.node.left != null) {
                stack.push(new tuple(t.node.left, t.level + 1));
            }
        }
        return res;
    }
}
