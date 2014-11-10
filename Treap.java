/* Ben Eggers
 *
 * This class is a treap--a type of randomized binary search tree. For more
 * information, see http://en.wikipedia.org/wiki/Treap.
 */

import java.util.Random;

public class Treap<T implements Comparable<T>> {
    private TreapNode root;

    public Treap<T>() {

    }

    /*
     * Returns the height of the treap. This is defined to be the maximum
     * number of hops necessary to get from the root to a leaf node.
     */
    public int height() {
        return height(root);
    }

    // Horribly inefficient, but oh well! That's what you get for writing
    // pedegogic code
    private int height(TreapNode r) {
        if (r == null || (r.right == null && r.left == null)) {
            return 0;
        } else {
            return 1 + max(height(r.right), height(r.left));
        }
    }

    /*
     * Node class for the Treap. Pretty much a basic binary search tree node.
     */
    public class TreapNode {
        T data;
        TreapNode left;
        TreapNode right;

        /*
         * Constructor for the TreapNode that takes a data item as a parameter.
         */
        public TreapNode(T data) {
            this(data, null, null);
        }

        /*
         * Constructor for the TreapNode that takes a data item, a left
         * TreapNode, and a right TreapNode as parameters.
         */
        public TreapNode(T data, TreapNode left, TreapNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
