package leetcode.leetcode21xx.leetcode2120;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        int n = 3;
        int[] startPos = {0, 1};
        String s = "RRDDLU";
        int[] expected = {1, 5, 4, 3, 1, 0};
        int[] actual = new Solution().executeInstructions(n, startPos, s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int n = 2;
        int[] startPos = {1, 1};
        String s = "LURD";
        int[] expected = {4, 1, 0, 0};
        int[] actual = new Solution().executeInstructions(n, startPos, s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test3() {
        int n = 1;
        int[] startPos = {0, 0};
        String s = "LRUD";
        int[] expected = {0, 0, 0, 0};
        int[] actual = new Solution().executeInstructions(n, startPos, s);
        assertArrayEquals(expected, actual);
    }


    @Test
    void test4() {
        int n = 2;
        int[] startPos = {0, 1};
        String s = "LRUDDLL";
        int[] expected = {2, 0, 0, 1, 2, 1, 1};
        int[] actual = new Solution().executeInstructions(n, startPos, s);
        assertArrayEquals(expected, actual);
    }
}