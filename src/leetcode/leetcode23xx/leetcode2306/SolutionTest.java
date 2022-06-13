package leetcode.leetcode23xx.leetcode2306;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] ideas = {"coffee", "donuts", "time", "toffee"};
        assertEquals(6, new Solution().distinctNames(ideas));
    }

    @Test
    void test2() {
        String[] ideas = {"lack", "back"};
        assertEquals(0, new Solution().distinctNames(ideas));
    }
}