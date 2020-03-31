package leetcode.leetcode6xx.leetcode605;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

    @Test
    void canPlaceFlowers() {
        Solution solution = new Solution();
        assertFalse(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }
}