package leetcode.leetcode36xx.leetcode3697;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void decimalRepresentation() {
        assertArrayEquals(new int[]{500, 30, 7}, new Solution().decimalRepresentation(537));
        assertArrayEquals(new int[]{100, 2}, new Solution().decimalRepresentation(102));
    }
}