/* Ben Eggers
 *
 * This class is an actual binary tree. Nothing fancy.
**/

public class BST<T extends Comparable<T>> extends AbstractBST<T> {

    public void remove(T data) {
        root = remove(data, root);
    }

    // Recursive helper for remove()
    private TreeNode remove(T data, TreeNode r) {
        if (r == null) {
            throw new IllegalArgumentException();
        }

        if (r.data.equals(data)) {
            size--;
            return null;
        } else if (r.data.compareTo(data) > 0) {
            r.left = remove(data, r.left);
        } else if (r.data.compareTo(data) < 0) {
            r.right = remove(data, r.right);
        }

        // Should never happen
        throw new RuntimeException();
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    // Helper for insert()
    private TreeNode insert(T data, TreeNode r) {
        if (r == null) {
            size++;
            return new TreeNode(data);
        } else if (r.data.compareTo(data) > 0) {
            r.left = insert(data, r.left);
        } else if (r.data.compareTo(data) < 0) {
            r.right = insert(data, r.right);
        }

    // We should never get here
    throw new RuntimeException();
    }
}
