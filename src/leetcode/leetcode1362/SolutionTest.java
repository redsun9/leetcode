package leetcode.leetcode1362;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void closestDivisors() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{3, 3}, solution.closestDivisors(8));
        assertArrayEquals(new int[]{3, 3}, solution.closestDivisors(7));
        assertArrayEquals(new int[]{25, 5}, solution.closestDivisors(123));
        assertArrayEquals(new int[]{40, 25}, solution.closestDivisors(999));
    }
}