// Ben Eggers
// Used to keep track of average tree stats (height, branching numbers)
// across many trials, so we can report averages
public class TreeStats {
    double averageHeight;
    double[] averageBranching;
    int trials;

    public TreeStats() {
        averageBranching = new double[3];
    }

    // Add a trial to the TreeStats object
    public void addTrial(int height, int[] branching) {
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
