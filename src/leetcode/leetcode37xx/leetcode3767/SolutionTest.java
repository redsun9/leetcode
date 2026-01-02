package leetcode.leetcode37xx.leetcode3767;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxPoints() {
        int[] technique1 = {5, 2, 10}, technique2 = {10, 3, 8};
        int k = 2;
        assertEquals(22, new Solution().maxPoints(technique1, technique2, k));
    }
}