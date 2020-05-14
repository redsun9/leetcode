package leetcode.leetcode14xx.leetcode1444;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] pizza = {"A..", "AAA", "..."};
        assertEquals(3, new Solution().ways(pizza, 3));
    }

    @Test
    void test2() {
        String[] pizza = {"A..", "AA.", "..."};
        assertEquals(1, new Solution().ways(pizza, 3));
    }

    @Test
    void test3() {
        String[] pizza = {"A..", "A..", "..."};
        assertEquals(1, new Solution().ways(pizza, 1));
    }
}