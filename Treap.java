/* Ben Eggers
 *
 * Randomized BST implementation.
 */

import java.util.*;

public class Treap<T extends Comparable<T>> extends AbstractBST<T> {
    protected TreapNode root;
    protected Random rand;

    public Treap() {
        super();
        rand = new Random();
    }

    public Treap(Collection<T> init) {
        super(init);
        rand = new Random();
    }

    public void remove(T data) {
        return;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private TreapNode insert(T data, TreapNode r) {
        if (r == null) {
            return new TreapNode(data);
        }
        return null;
    }

    public class TreapNode extends TreeNode {
        int height;

        public TreapNode(T data) {
            this(data, null, null);
        }

        public TreapNode(T data, TreapNode left, TreapNode right) {
            super(data, left, right);
            this.height = Math.max(left.height, right.height) + 1;
        }
    }
}
