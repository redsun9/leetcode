package leetcode.leetcode23xx.leetcode2338;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(10, new Solution().idealArrays(2, 5));
        assertEquals(11, new Solution().idealArrays(5, 3));
        assertEquals(1998089, new Solution().idealArrays(9767, 9557));
    }
}