package leetcode.leetcode13xx.leetcode1312;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String s = "zzazz";
        assertEquals(0, new Solution().minInsertions(s));
    }

    @Test
    void test2() {
        String s = "mbadm";
        assertEquals(2, new Solution().minInsertions(s));
    }

    @Test
    void test3() {
        String s = "leetcode";
        assertEquals(5, new Solution().minInsertions(s));
    }

    @Test
    void test4() {
        String s = "g";
        assertEquals(0, new Solution().minInsertions(s));
    }

    @Test
    void test5() {
        String s = "no";
        assertEquals(1, new Solution().minInsertions(s));
    }
}