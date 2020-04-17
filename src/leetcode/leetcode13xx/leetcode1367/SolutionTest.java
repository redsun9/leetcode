package leetcode.leetcode13xx.leetcode1367;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.ListNode;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test() {
        TreeNode treeNode = LeetcodeUtils.initializeTree(
                new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3}
        );
        ListNode listNode = LeetcodeUtils.initializeList(new int[]{1, 4, 2, 6});
        SolutionWithTrie solution = new SolutionWithTrie();
        assertTrue(solution.isSubPath(listNode, treeNode));
    }

    @Test
    void test2() {
        TreeNode treeNode = LeetcodeUtils.initializeTree(
                new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3}
        );
        ListNode listNode = LeetcodeUtils.initializeList(new int[]{1, 4, 2, 6});
        SolutionWithPointers solution = new SolutionWithPointers();
        assertTrue(solution.isSubPath(listNode, treeNode));
    }
}