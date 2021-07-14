package leetcode.leetcode4xx.leetcode468;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        assertEquals("Neither", new Solution().validIPAddress(ip));
    }
}