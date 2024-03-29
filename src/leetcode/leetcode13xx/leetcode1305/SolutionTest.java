package leetcode.leetcode13xx.leetcode1305;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        TreeNode first = LeetcodeUtils.initializeTree(new Integer[]{2, 1, 4});
        TreeNode second = LeetcodeUtils.initializeTree(new Integer[]{1, 0, 3});
        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 4);
        assertEquals(expected, solution.getAllElements(first, second));
        assertEquals(expected, solution2.getAllElements(first, second));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        TreeNode first = LeetcodeUtils.initializeTree(new Integer[]{0, -10, 10});
        TreeNode second = LeetcodeUtils.initializeTree(new Integer[]{5, 1, 7, 0, 2});
        List<Integer> expected = Arrays.asList(-10, 0, 0, 1, 2, 5, 7, 10);
        assertEquals(expected, solution.getAllElements(first, second));
        assertEquals(expected, solution2.getAllElements(first, second));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        TreeNode first = LeetcodeUtils.initializeTree(new Integer[]{});
        TreeNode second = LeetcodeUtils.initializeTree(new Integer[]{5, 1, 7, 0, 2});
        List<Integer> expected = Arrays.asList(0, 1, 2, 5, 7);
        assertEquals(expected, solution.getAllElements(first, second));
        assertEquals(expected, solution2.getAllElements(first, second));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        TreeNode first = LeetcodeUtils.initializeTree(new Integer[]{0, -10, 10});
        TreeNode second = LeetcodeUtils.initializeTree(new Integer[]{});
        List<Integer> expected = Arrays.asList(-10, 0, 10);
        assertEquals(expected, solution.getAllElements(first, second));
        assertEquals(expected, solution2.getAllElements(first, second));
    }

    @Test
    void test5() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        TreeNode first = LeetcodeUtils.initializeTree(new Integer[]{1, null, 8});
        TreeNode second = LeetcodeUtils.initializeTree(new Integer[]{8, 1});
        List<Integer> expected = Arrays.asList(1, 1, 8, 8);
        assertEquals(expected, solution.getAllElements(first, second));
        assertEquals(expected, solution2.getAllElements(first, second));
    }
}