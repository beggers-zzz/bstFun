/* Ben Eggers
 *
 * This class' main method creates a BST and Treap, and does
 * some inserts/removals on them to test their effectiveness.
 * Also (of course) reports some stats.
 */

import java.util.Random;

public class BSTMain {

    public static final int ELEMS = 1000;
    public static final int NUM_TESTS = 100;
    public static Random rand = new Random();

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        TreeStats bstStats = new TreeStats();

        System.out.println("-----------------------------------");
        System.out.println("Running with " + ELEMS + " inserts.");
        System.out.println("-----------------------------------");
        System.out.println();

        for (int i = 0; i < NUM_TESTS; i++) {
            bstStats.add(sortedInsert(bst));
        }
        System.out.println("BST with sorted insert:");
        report(bstStats);

        bstStats.clear();
        bst.clear();
        for (int i = 0; i < NUM_TESTS; i++) {
            bstStats.add(randomInsert(bst));
        }
        System.out.println("BST with random insert:");
        report(bstStats);
/*
        bstStats.clear();
        bst.clear();
        for (int i = 0; i < NUM_TESTS; i++) {
            bstStats.add(perfectInsert(bst));
        }
        System.out.println("BST with perfectly-ordered insert");
        report(bstStats);
  */
    }

    public static TreeStats sortedInsert(AbstractBST<Integer> t) {
        t.clear();
        for (int i = 0; i < ELEMS; i++) {
            t.insert(i);
        }
        TreeStats ts = new TreeStats();
        ts.addTrial(t.height(), t.getBranchingNumbers());
        return ts;
    }

    public static TreeStats randomInsert(AbstractBST<Integer> t) {
        t.clear();
        for (int i = 0; i < ELEMS; i++) {
            t.insert(rand.nextInt());
        }
        TreeStats ts = new TreeStats();
        ts.addTrial(t.height(), t.getBranchingNumbers());
        return ts;
    }

    public static TreeStats perfectInsert(AbstractBST<Integer> t) {
        t.clear();
        return new TreeStats();
    }

    public static void report(TreeStats ts) {
        System.out.println("\tAverage height: " + ts.averageHeight);
//        System.out.println("Percentage of ideal height: "
//                         + (Math.abs(Math.log(2, ELMS) - ts.averageHeight) / Math.log(2, ELEMS)) * 100);

        System.out.println("\tAverage branching factors:");
        System.out.println("\t\t0: " + ts.averageBranching[0]);
        System.out.println("\t\t1: " + ts.averageBranching[1]);
        System.out.println("\t\t2: " + ts.averageBranching[2]);
    }
}
