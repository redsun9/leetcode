package leetcode.leetcode22xx.leetcode2223;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {
    @Test
    void test1() {
        String s = "babab";
        assertEquals(9, new Solution().sumScores(s));
    }

    @Test
    void test2() {
        String s = "azbazbzaz";
        assertEquals(14, new Solution().sumScores(s));
    }
}