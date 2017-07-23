package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class Validate_Binary_Search_Tree {

    public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
    }

    public static void main(String[] args) {

    }
    // divide and Couqer
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }

        return helper(root.left, min, Math.min(root.val, max)) & helper(root.right, Math.max(root.val, min), max);
    }



    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }

        if (list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
