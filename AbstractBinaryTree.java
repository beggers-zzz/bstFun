/* Ben Eggers
 *
 * This class represents an abstract binary tree.
 */

import java.util.*;
import java.math.*;

public abstract class AbstractBinaryTree<T extends Comparable<T>> {
    private TreeNode root;
    private int size;

    /*
     * Construct an empty AbstractBinaryTree.
     */
    public AbstractBinaryTree() {
        // nothing to do
    }

    /*
     * Construct a AbstractBinaryTree using the passed Collection. If the passed Collection
     * is null, throws an IllegalArgumentException.
     */
    public AbstractBinaryTree(Collection<T> init) {
        if (init == null) {
            throw new IllegalArgumentException();
        }

        for (T item : init) {
            insert(item);
            size++;
        }
    }

    /*
     * Get the passed data item from the tree. If it's not in the tree, returns
     * null.
     */
    public T get(T data) {
        return get(data, root);
    }

    // Recursive helper for get().
    private T get(T data, TreeNode r) {
        if (r == null) {
            return null;
        } else if (r.data.equals(data)) {
            return r.data;
        } else if (r.data.compareTo(data) > 0) {
            return get(data, r.left);
        } else if (r.data.compareTo(data) < 0) {
            return get(data, r.right);
        } else {
            // Should never be reached, we're just being safe
            throw new RuntimeException("Poor logic on programmer's part");
        }
    }

    /*
     * Get the number of items in the AbstractBinaryTree.
     */
    public int size() {
        return size;
    }

    /*
     * Get the number of "node types" of the tree-the first array slot will
     * contain the number of nodes with 0 children, the second will contain
     * the number of nodes with 1 child, and the 3rd will contain the number
     * of nodes with 2 children.
     */
    public int[] getBranchingNumbers() {
        int[] nums = new int[3];
        getBranchingNumbers(nums, root);
        return nums;
    }

    // Private helper for getBranchingNumbers
    private void getBranchingNumbers(int[] nums, TreeNode r) {
        if (r != null) {
            if (r.left == null && r.right == null) {
                nums[0]++;
            } else if (r.left != null && r.right != null) {
                nums[2]++;
            } else {
                nums[1]++;
            }

            getBranchingNumbers(nums, r.left);
            getBranchingNumbers(nums, r.right);
        }
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
    private int height(TreeNode r) {
        if (r == null || (r.right == null && r.left == null)) {
            return 0;
        } else {
            return 1 + Math.max(height(r.right), height(r.left));
        }
    }


    // Abstract methods

    /*
     * Insert a data item into the tree.
     */
    public abstract void insert(T data);

    /*
     * Remove a data item from the tree.
     */
    public abstract void remove(T data);


    /*
     * Node class for the AbstractBinaryTree. Pretty much a basic binary search tree node.
     */
    public class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        /*
         * Constructor for the TreeNode that takes a data item as a parameter.
         */
        public TreeNode(T data) {
            this(data, null, null);
        }

        /*
         * Constructor for the TreeNode that takes a data item, a left
         * TreeNode, and a right TreeNode as parameters.
         */
        public TreeNode(T data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
