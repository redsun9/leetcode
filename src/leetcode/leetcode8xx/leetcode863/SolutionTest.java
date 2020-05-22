package leetcode.leetcode8xx.leetcode863;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Integer[] vals = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = LeetcodeUtils.initializeTree(vals);
        assertEquals(Set.of(1, 4, 7), new HashSet<>(new Solution().distanceK(root, 5, 2)));
    }
}