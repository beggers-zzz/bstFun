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
    }

    public static TreeStats sortedInsert(AbstractBST<Integer> t) {
        t.clear();
        for (int i = 0; i < ELEMS; i++) {
            t.insert(i);
        }
        TreeStats ts = new TreeStats();
        ts.addTrial(t.height(), t.getBranchingNumbers());
    }

    public static void report(TreeStats ts) {
        System.out.println("\tAverage height: " + ts.averageHeight);

        System.out.println("\tAverage branching factors:");
        System.out.println("\t\t0: " + ts.averageBranching[0]);
        System.out.println("\t\t1: " + ts.averageBranching[1]);
        System.out.println("\t\t2: " + ts.averageBranching[2]);
    }

    // Used to keep track of average tree stats (height, branching numbers)
    // across many trials, so we can report averages
    private class TreeStats {
        double averageHeight;
        double[] averageBranching;
        int trials;

        public TreeStats() {
            averageBranching = new double[3];
        }

        // Add a trial to the TreeStats object
        public void addTrail(int height, int[] branching) {
            // multiply by trials to get the totals
            averageHeight *= trials;
            for (int i = 0; i < averageBranching.length; i++) {
                averageBranching[i] *= trials;
            }

            // Add the passed trial to our totals
            averageHeight += height;
            for (int i = 0; i < averageBranching.length; i++) {
                averageBranching[i] += branching[i];
            }

            // And normalize everything by the new number of trials
            trials++;
            averageHeight /= trials;
            for (int i = 0; i < averageBranching.length; i++) {
                averageBranching[i] /= trials;
            }
        }

        public void clear() {
            averageHeight = trials = 0;
            for (int i = 0; i < averageBranching.length; i++) {
                averageBranching[i] = 0;
            }
        }

        public void add(TreeStats other) {
            this.averageHeight *= this.trials;
            for (int i = 0; i < this.averageBranching.length; i++) {
                this.averageBranching[i] *= this.trials;
            }

            this.averageHeight += other.averageHeight * other.trials;
            for (int i = 0; i < this.averageBranching.length; i++) {
                this.averageBranching[i] += other.averageBranching[i] * other.trials;
            }

            this.trials += other.trials;

            this.averageHeight /= this.trials;
            for (int i = 0; i < this.averageBranching.length; i++) {
                this.averageBranching[i] /= this.trials;
            }
        }
    }
}
