package leetcode.leetcode3xx.leetcode394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    }
}