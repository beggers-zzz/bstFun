/* Ben Eggers
 *
 * This class is a treap--a type of randomized binary search tree. For more
 * information, please see http://en.wikipedia.org/wiki/Treap.
 */

public class Treap<T implements Comparable<T>> {




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
