package leetcode.leetcode37xx.leetcode3774;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void absDifference() {
        assertEquals(5, new Solution().absDifference(new int[]{5, 2, 2, 4}, 2));
        assertEquals(5, new Solution2().absDifference(new int[]{5, 2, 2, 4}, 2));
    }
}