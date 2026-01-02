package leetcode.leetcode37xx.leetcode3771;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void totalScore() {
        int hp = 11;
        int[] damage = {3, 6, 7}, requirement = {4, 2, 5};
        assertEquals(3, new Solution().totalScore(hp, damage, requirement));
        assertEquals(3, new Solution2().totalScore(hp, damage, requirement));

    }
}