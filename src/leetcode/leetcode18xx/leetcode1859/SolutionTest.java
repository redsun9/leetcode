package leetcode.leetcode18xx.leetcode1859;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("This is a sentence", new Solution().sortSentence("is2 sentence4 This1 a3"));
    }

    @Test
    void test2() {
        assertEquals("Me Myself and I", new Solution().sortSentence("Myself2 Me1 I4 and3"));
    }
}