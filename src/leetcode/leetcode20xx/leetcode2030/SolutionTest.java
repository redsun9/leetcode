package leetcode.leetcode20xx.leetcode2030;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "leet", expected = "eet";
        int k = 3, repetition = 1;
        char letter = 'e';
        assertEquals(expected, new Solution().smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    void test2() {
        String s = "leetcode", expected = "ecde";
        int k = 4, repetition = 2;
        char letter = 'e';
        assertEquals(expected, new Solution().smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    void test3() {
        String s = "bb", expected = "bb";
        int k = 2, repetition = 2;
        char letter = 'b';
        assertEquals(expected, new Solution().smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    void test4() {
        String s = "mmmxmxymmm", expected = "mmmmxmmm";
        int k = 8, repetition = 4;
        char letter = 'm';
        assertEquals(expected, new Solution().smallestSubsequence(s, k, letter, repetition));
    }
}