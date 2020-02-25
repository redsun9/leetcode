package leetcode.leetcode149;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxPoints() {
        assertEquals(3, new Solution().maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}