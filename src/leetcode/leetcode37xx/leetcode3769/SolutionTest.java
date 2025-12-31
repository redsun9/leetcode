package leetcode.leetcode37xx.leetcode3769;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void sortByReflection() {
        assertArrayEquals(new int[]{4, 4, 5}, new Solution().sortByReflection(new int[]{4, 5, 4}));
    }
}