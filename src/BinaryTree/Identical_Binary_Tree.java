package BinaryTree;

public class Identical_Binary_Tree {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        boolean left = isIdentical(a.left, b.left);
        boolean right = isIdentical(a.right, b.right);

        return left && right;

    }
}
