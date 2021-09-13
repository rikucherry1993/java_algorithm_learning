package javabasic.algorithm;

import java.util.Random;

/**
 * Check whether a BST is valid.
 */
public class ValidateBST {
    public static int steps = 0;

    public static void main(String[] args) {
        runTests(5, 10);
        runTests(10, 10);
        runTests(20, 10);
        runTests(30, 10);
        runTests(40, 10);
        runTests(60, 10);
        runTests(70, 10);
        runTests(80, 10);
        runTests(90, 10);
        runTests(100, 10);
        runTests(200, 10);
        runTests(400, 10);
        runTests(1000, 10);
    }

    /**
     * Target algorithm
     * @param tree
     * @return
     */
    public static boolean validateBst(BST tree) {
        // Write your code here.
        if (tree == null) return true;

        if (tree.left != null) {
            steps++;
            if (tree.value <= getMaxVal(tree.left)) return false;
        }

        if (tree.right != null) {
            steps++;
            if (tree.value > getMinVal(tree.right)) return false;
        }

        return validateBst(tree.left) && validateBst(tree.right);
    }

    public static int getMaxVal(BST tree){
        steps++;
        if (tree.right == null) {
            return tree.value;
        } else {
            return getMaxVal(tree.right);
        }
    }

    public static int getMinVal(BST tree){
        steps++;
        if (tree.left == null) {
            return tree.value;
        } else {
            return getMinVal(tree.left);
        }
    }

    /**
     * Run target algorithm and calculate complexity
     * @param n number of nodes
     * @param rootKey value of the root node
     */
    public static void runTests(int n, int rootKey) {
        //the root node
        BST root = new BST(rootKey);
        Random random = new Random();

        for (int i = 0; i <=n; i++) {
            int key = random.nextInt();
            root.insert(key);
        }

        int depth = getDepth(root);
        System.out.println("Is root a valid BST?: " + validateBst(root));
        System.out.println("Input tree has " + n
                + " nodes with depth of " + depth
                + " Calculation took " + steps + " steps.");
        steps = 0;
    }


    public static int getDepth(BST tree){
        if (tree == null) {
            return 0;
        }

        int left = getDepth(tree.left);
        int right = getDepth(tree.right);
        return left > right? left+1 : right+1;

    }

    /**
     * BST class
     */
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        /**
         * insert a node to a BST
         * @param key
         * @return
         */
        public BST insert(int key){
            BST current = this;
            while(true){
                if (key < current.value) {
                    if (current.left == null) {
                        current.left = new BST(key);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null){
                        current.right = new BST(key);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
            return current;
        }
    }
}
