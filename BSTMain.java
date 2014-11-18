/* Ben Eggers
 *
 * This class' main method creates a BST, RandomizedBST, and Treap, and does
 * some inserts/removals on them to test their effectiveness.
 */

public class BSTMain {

    public static void main(String[] args) {
        BST<Integer> t = new BST<Integer>();
        for (int i = 0; i < 100; i++) {
            t.insert(i);
        }
        int h = t.height();
        System.out.println("Height for linked list tree is " + h);

        int[] bf = t.getBranchingNumbers();
        System.out.println("Branching factors:");
        System.out.println("\t0: " + bf[0]);
        System.out.println("\t1: " + bf[1]);
        System.out.println("\t2: " + bf[2]);
    }

}
