package leetcode.leetcode25xx.leetcode2513;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minimizeSet() {
        int divisor1 = 78789;
        int divisor2 = 42659;
        int uniqueCnt1 = 58291;
        int uniqueCnt2 = 182389;
        assertEquals(240680, new Solution().minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2));
    }
}