/* Ben Eggers
 *
 * Randomized BST implementation.
 */

public class RandomizedBST<T extends Comparable<T>> extends AbstractBST<T> {
    protected RandTreeNode root;

    public void remove(T data) {
        return;
    }

    public void insert(T data) {
        return;
    }

    public class RandTreeNode extends TreeNode {
        int height;

        public RandTreeNode(T data, RandTreeNode left, RandTreeNode right) {
            super(data, left, right);
            this.height = Math.max(left.height, right.height) + 1;
        }
    }
}
