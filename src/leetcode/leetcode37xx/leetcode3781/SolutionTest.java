package leetcode.leetcode37xx.leetcode3781;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maximumScore() {
        assertEquals(7, new Solution().maximumScore(new int[]{2, 1, 5, 2, 3}, "01010"));
    }
}