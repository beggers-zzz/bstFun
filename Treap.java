/* Ben Eggers
 *
 * Treap BST implementation.
 */

import java.util.*;

public class Treap<T extends Comparable<T>> extends AbstractBST<T> {
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

    private TreeNode insert(T data, TreeNode r) {
        if (r == null) {
            return new TreeNode(data);
        }
        return null;
    }
}
