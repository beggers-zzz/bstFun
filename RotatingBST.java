/* Ben Eggers
 *
 * This (abstract) class implements the common rotating operations on a BST.
 * Don't call any of these methods on leaf nodes--things will break.
 */

import java.util.Collection;

public abstract class RotatingBST<T extends Comparable<T>> extends AbstractBST<T> {

    public RotatingBST() {
        // do nothing
    }

    public RotatingBST(Collection<T> init) {
        super(init);
    }

    public TreeNode rotRightRight(TreeNode root) {
        TreeNode newRoot = root.right;
        TreeNode rl = newRoot.left;
        newRoot.left = root;
        root.right = rl;
        return newRoot;
    }

    public TreeNode rotRightLeft(TreeNode root) {
        root.right = rotLeftLeft(root.right);
        return rotRightRight(root);
    }

    public TreeNode rotLeftLeft(TreeNode root) {
        TreeNode newRoot = root.left;
        TreeNode lr = newRoot.right;
        newRoot.right = root;
        root.left = lr;
        return newRoot;
    }

    public TreeNode rotLeftRight(TreeNode root) {
        root.left = rotRightRight(root.left);
        return rotLeftLeft(root);
    }
}
