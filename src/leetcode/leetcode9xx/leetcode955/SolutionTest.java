package leetcode.leetcode9xx.leetcode955;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] a = {"cba", "daf", "ghi"};
        assertEquals(0, new Solution().minDeletionSize(a));
    }

    @Test
    void test2() {
        String[] a = {"a", "b"};
        assertEquals(0, new Solution().minDeletionSize(a));
    }

    @Test
    void test3() {
        String[] a = {"zyx", "wvu", "tsr"};
        assertEquals(3, new Solution().minDeletionSize(a));
    }
}