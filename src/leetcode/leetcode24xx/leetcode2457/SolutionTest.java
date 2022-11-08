package leetcode.leetcode24xx.leetcode2457;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        long n = 94598;
        int target = 6;
        assertEquals(5402, new Solution().makeIntegerBeautiful(n, target));
    }
}