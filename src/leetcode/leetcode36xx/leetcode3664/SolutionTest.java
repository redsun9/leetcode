package leetcode.leetcode36xx.leetcode3664;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] cards = {"aa", "ab", "ba", "ac"};
        char x = 'a';
        assertEquals(2, new Solution().score(cards, x));
    }

    @Test
    void test2() {
        String[] cards = {"aa", "ab", "ba"};
        char x = 'a';
        assertEquals(1, new Solution().score(cards, x));
    }

    @Test
    void test3() {
        String[] cards = {"aa", "ab", "ba", "ac"};
        char x = 'b';
        assertEquals(0, new Solution().score(cards, x));
    }
}