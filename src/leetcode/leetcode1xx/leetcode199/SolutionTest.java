package leetcode.leetcode1xx.leetcode199;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Integer[] nums = {1, 2, 3, 4};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        assertEquals(Set.of(1, 3, 4), new HashSet<>(new Solution().rightSideView(root)));
    }
}