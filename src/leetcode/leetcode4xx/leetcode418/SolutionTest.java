package leetcode.leetcode4xx.leetcode418;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int rows = 4, cols = 5;
        String[] sentence = {"I", "had", "apple", "pie"};
        assertEquals(1, new Solution().wordsTyping(sentence, rows, cols));
    }

    @Test
    void test2() {
        int rows = 2, cols = 8;
        String[] sentence = {"hello", "world"};
        assertEquals(1, new Solution().wordsTyping(sentence, rows, cols));
    }

    @Test
    void test3() {
        int rows = 3, cols = 6;
        String[] sentence = {"a", "bcd", "e"};
        assertEquals(2, new Solution().wordsTyping(sentence, rows, cols));
    }
}