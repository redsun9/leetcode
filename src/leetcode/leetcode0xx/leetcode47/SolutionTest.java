package leetcode.leetcode0xx.leetcode47;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void permuteUnique() {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(new int[]{1, 1, 1, 2, 2});
        System.out.println(res);
    }
}