package BinaryTree;

/**
 * Created by qianle on 7/17/17.
 */
public class Invert_Binary_Tree {

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {

    }

    public void invertBinaryTree(TreeNode root) {
        if (root == null) return;
        //invert
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return;
    }

}
