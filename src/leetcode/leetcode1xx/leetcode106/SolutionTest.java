package leetcode.leetcode1xx.leetcode106;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void test1() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = LeetcodeUtils.initializeTree(arr);
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        assertEquals(root, new Solution().buildTree(inorder, postorder));
        assertEquals(root, new Solution2().buildTree(inorder, postorder));
    }

    @Test
    void testRecursiveSolutionOnBalancedTrees() {
        int n = 10000;
        int minValue = 0;
        int maxValue = 1000000;
        int numberOfTests = 1_000;
        Solution solution = new Solution();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            TreeNode root = LeetcodeUtils.generateBalancedTree(minValue, maxValue, n, new Random());
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(root);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(root);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            assertEquals(root, solution.buildTree(inorder, postorder));
        });
    }

    @Test
    void testIterativeSolutionOnBalancedTrees() {
        int n = 10000;
        int minValue = 0;
        int maxValue = 1000000;
        int numberOfTests = 1_000;
        Solution2 solution = new Solution2();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            TreeNode root = LeetcodeUtils.generateBalancedTree(minValue, maxValue, n, new Random());
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(root);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(root);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            assertEquals(root, solution.buildTree(inorder, postorder));
        });
    }

    @Test
    void testRecursiveSolutionOnRandomTrees() {
        int n = 10000;
        int minValue = 0;
        int maxValue = 1000000;
        int numberOfTests = 1_000;
        Solution solution = new Solution();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            TreeNode root = LeetcodeUtils.generateRandomTree(minValue, maxValue, n, new Random());
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(root);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(root);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            assertEquals(root, solution.buildTree(inorder, postorder));
        });
    }

    @Test
    void testIterativeSolutionOnRandomTrees() {
        int n = 10000;
        int minValue = 0;
        int maxValue = 1000000;
        int numberOfTests = 1_000;
        Solution2 solution = new Solution2();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            TreeNode root = LeetcodeUtils.generateRandomTree(minValue, maxValue, n, new Random());
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(root);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(root);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            assertEquals(root, solution.buildTree(inorder, postorder));
        });
    }

    @Test
    void testRecursiveSolutionOnDegeneratedTrees() {
        int n = 100000;
        int minValue = 0;
        int maxValue = 1000000;
        int numberOfTests = 100;
        Solution solution = new Solution();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            TreeNode root = LeetcodeUtils.generateDegenerateTree(minValue, maxValue, n, new Random());
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(root);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(root);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            assertThrows(StackOverflowError.class, () -> solution.buildTree(inorder, postorder));
        });
    }

    @Test
    void testIterativeSolutionOnDegeneratedTrees() {
        int n = 100000;
        int minValue = 0;
        int maxValue = 1000000;
        int numberOfTests = 100;
        Solution2 solution = new Solution2();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            TreeNode root = LeetcodeUtils.generateDegenerateTree(minValue, maxValue, n, new Random());
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(root);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(root);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            assertEquals(root, solution.buildTree(inorder, postorder));
        });
    }
}