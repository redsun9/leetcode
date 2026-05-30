package leetcode.leetcode39xx.leetcode3941;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void passwordStrength() {
        assertEquals(11, new Solution().passwordStrength("aA1!"));
        assertEquals(11, new Solution().passwordStrength("bbB11#"));
    }
}