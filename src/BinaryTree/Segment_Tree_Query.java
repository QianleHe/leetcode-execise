package BinaryTree;

public class Segment_Tree_Query {
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

    public class Solution {
        /**
         *@param root, start, end: The root of segment tree and
         *                         an segment / interval
         *@return: The maximum number in the interval [start, end]
         */
        public int query(SegmentTreeNode root, int start, int end) {
            if (start == root.start && end == root.end) return root.max;
            int mid = root.start + (root.end - root.start) / 2;
            int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
            if (start <= mid) {
                if (end > mid) {
                    leftMax = query(root.left, start, mid);
                } else {
                    leftMax = query(root.left, start, end);
                }
            }
            if (mid < end) {
                if (start <= mid) {
                    rightMax = query(root.right, mid + 1, end);
                } else {
                    rightMax = query(root.right, start, end);
                }
            }
            return Math.max(leftMax, rightMax);
        }
    }
}
