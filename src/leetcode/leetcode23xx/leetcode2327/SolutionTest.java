package leetcode.leetcode23xx.leetcode2327;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        int n = 6, delay = 2, forget = 4;
        assertEquals(5, new Solution().peopleAwareOfSecret(n, delay, forget));
        assertEquals(5, new Solution2().peopleAwareOfSecret(n, delay, forget));
        assertEquals(5, new Solution3().peopleAwareOfSecret(n, delay, forget));
    }

    @Test
    void test2() {
        int n = 4, delay = 1, forget = 3;
        assertEquals(6, new Solution().peopleAwareOfSecret(n, delay, forget));
        assertEquals(6, new Solution2().peopleAwareOfSecret(n, delay, forget));
        assertEquals(6, new Solution3().peopleAwareOfSecret(n, delay, forget));
    }
}