package leetcode.leetcode22xx.leetcode2243;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "93582987831364765383758451306569574", expected = "10875";
        int k = 20;
        assertEquals(expected, new Solution().digitSum(s, k));
    }
}