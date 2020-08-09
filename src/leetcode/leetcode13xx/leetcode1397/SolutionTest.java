package leetcode.leetcode13xx.leetcode1397;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(51, new Solution().findGoodStrings(2, "aa", "da", "b"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().findGoodStrings(8, "leetcode", "leetgoes", "leet"));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().findGoodStrings(2, "gx", "gz", "x"));
    }
}
