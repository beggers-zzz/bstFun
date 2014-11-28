/* Ben Eggers
 *
 * This class' main method creates a BST and Treap, and does
 * some inserts/removals on them to test their effectiveness.
 * Also (of course) reports some stats.
 */

import java.util.*;

public class BSTMain {

    public static final int ELEMS = 1023;
    public static final int NUM_TESTS = 1024;
    public static Random rand = new Random();

    public static void main(String[] args) {
        AbstractBST<Integer> bst = new BST<Integer>();
        TreeStats bstStats = new TreeStats();
        TreeStats treapStats = new TreeStats();

        System.out.println("-------------------------------------------------------------");
        System.out.println("Running with " + NUM_TESTS + " trials of " + ELEMS + " inserts each.");
        System.out.println("-------------------------------------------------------------");
        System.out.println();

        /*
         * Sorted Insert
         */

        // We'll only do one, since it's all deterministic anyway
        bstStats.add(sortedInsert(bst));
        System.out.println("BST with sorted insert:");
        report(bstStats);

        // Get ready for the next set of trials
        bstStats.clear();
        treapStats.clear();

        /*
         * Random Insert
         */

        for (int i = 0; i < NUM_TESTS; i++) {
            bstStats.add(randomInsert(bst));
        }
        System.out.println("BST with random insert:");
        report(bstStats);

        // Get ready for the next set of trials
        bstStats.clear();
        treapStats.clear();

        /*
         * Perfect Insert (create perfect BST if it's deterministic)
         */

        // Only one trial on BST, since it's deterministic
        bstStats.add(perfectInsert(bst));
        System.out.println("BST with perfectly-ordered insert");
        report(bstStats);
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
        // Keeps track of what we've put in so we don't do duplicates
        Set<Integer> s = new HashSet<Integer>();
        while (s.size() < ELEMS) {
            int n = rand.nextInt();
            if (!s.contains(n)) {
                t.insert(n);
                s.add(n);
            }
        }
        TreeStats ts = new TreeStats();
        ts.addTrial(t.height(), t.getBranchingNumbers());
        return ts;
    }

    public static TreeStats perfectInsert(AbstractBST<Integer> t) {
        t.clear();
        perfectInsert(t, 0, ELEMS - 1);
        TreeStats ts = new TreeStats();
        ts.addTrial(t.height(), t.getBranchingNumbers());
        return ts;
    }

    // Adds, in perfect BST order, numbers from lo to hi (inclusive-inclusive)
    // to the tree
    public static void perfectInsert(AbstractBST<Integer> t, int lo, int hi) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;
            t.insert(mid);
            perfectInsert(t, lo, mid - 1);
            perfectInsert(t, mid + 1, hi);
        }
    }

    public static void report(TreeStats ts) {
        System.out.println("\tAverage height: " + ts.averageHeight);
        int idealHeight = (int) Math.floor(Math.log(ELEMS) / Math.log(2));
        double error = 1.0 * ts.averageHeight / idealHeight;
        System.out.println("\tPercentage of ideal height (" + idealHeight + "): " + error * 100);

        System.out.println("\tAverage branching factors:");
        System.out.println("\t\t0: " + ts.averageBranching[0]);
        System.out.println("\t\t1: " + ts.averageBranching[1]);
        System.out.println("\t\t2: " + ts.averageBranching[2]);
    }
}
