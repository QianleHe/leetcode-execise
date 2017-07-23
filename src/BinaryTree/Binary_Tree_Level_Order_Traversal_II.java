package BinaryTree;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    class tuple {
        public int level;
        public TreeNode node;
        public tuple(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        //ArrayList<Integer> list = new ArrayList<>();
        Stack<tuple> stack = new Stack<>();

        if (root != null) {
            stack.push(new tuple(0, root));
        }

        while (!stack.isEmpty()) {
            tuple t = stack.pop();
            if (res.size() <= t.level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(t.level).add(t.node.val);
            if (t.node.right != null) {
                stack.push(new tuple(t.level + 1, t.node.right));
            }
            if (t.node.left != null) {
                stack.push(new tuple(t.level + 1, t.node.left));
            }
        }
        Collections.reverse(res);
        return res;
    }

}
