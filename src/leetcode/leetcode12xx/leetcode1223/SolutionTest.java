package leetcode.leetcode12xx.leetcode1223;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        int n = 2, expected = 34;
        int[] rollMax = {1,1,2,2,2,3};
        assertEquals(expected, new Solution().dieSimulator(n,rollMax));

    }
}