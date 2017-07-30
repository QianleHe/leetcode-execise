package BinaryTree;

public class Segment_Tree_Modify {
    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        if (root == null) return;
        int mid = root.start + (root.end - root.start) / 2;
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        if (root.start <= index && mid >= index) {
            modify(root.left, index, value);
        }
        if (root.end >= index && mid + 1 <= index) {
            modify(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
        return;
    }
}
