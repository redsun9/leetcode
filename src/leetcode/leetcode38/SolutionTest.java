package leetcode.leetcode38;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void countAndSay() {
        Solution solution = new Solution();
        assertEquals("1", solution.countAndSay(1));
        assertEquals("11", solution.countAndSay(2));
        assertEquals("21", solution.countAndSay(3));
        assertEquals("1211", solution.countAndSay(4));
        assertEquals("111221", solution.countAndSay(5));

    }
}