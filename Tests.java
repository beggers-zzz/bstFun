/* Ben Eggers
 *
 * Tests for all our beautiful BSTs. This is a pretty kludgy test suite so don't
 * copy its style--I only did it like this because I don't want to fight with
 * CLI JUnit.
**/

import java.util.*;

public class Tests {


    public static void main(String[] args) {
        int fails = 0;

        fails += testConstructors();
        fails += testSize();
        fails += testInsertThenSize();
        fails += testInsertThenGet();
        fails += testInsertThenRemove();
        fails += testInOrderTraversalSorted();
        fails += testBSTHeight();
        fails += testBSTBranchingNumbers();

        System.out.println();

        // It's like our own hack-y JUnit!
        if (fails == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("FAILURES!!!!");
        }
    }

    // Tests the constructors, prpublic static inting out a "." for each passed test or a
    // "E" and some information for a failed test. Returns the number of
    // failed tests.
    public static int testConstructors() {
        return 0;
    }

    // Tests the size() method, prpublic static inting out a "." for each passed test or a
    // "E" and some information for a failed test. Returns the number of
    // failed tests.
    public static int testSize() {
        return 0;
    }

    // Tests that the insert() method increases the size, prpublic static inting out a "."
    // for each passed test or a "E" and some information for a failed test.
    // Returns the number of failed tests.
    public static int testInsertThenSize() {
        return 0;
    }

    // Tests that the get() method retrieves things that have been inserted,
    // prpublic static inting out a "." for each passed test or a "E" and some information
    // for a failed test. Returns the number of failed tests.
    public static int testInsertThenGet() {
        return 0;
    }

    // Tests that the remove() method can remove things that have been inserted,
    // prpublic static inting out a "." for each passed test or a "E" and some information
    // for a failed test. Returns the number of failed tests.
    public static int testInsertThenRemove() {
        return 0;
    }

    // Tests that the inOrderTraversal() method returns a sorted list,
    // prpublic static inting out a "." for each passed test or a "E" and some information
    // for a failed test. Returns the number of failed tests.
    public static int testInOrderTraversalSorted() {
        return 0;
    }

    // Tests that BSTs (and only BSTs) have the correct height,
    // prpublic static inting out a "." for each passed test or a "E" and some information
    // for a failed test. Returns the number of failed tests.
    public static int testBSTHeight() {
        return 0;
    }

    // Tests that BSTs (and only BSTs) have the correct branching numbers,
    // prpublic static inting out a "." for each passed test or a "E" and some information
    // for a failed test. Returns the number of failed tests.
    public static int testBSTBranchingNumbers() {
        return 0;
    }
}
