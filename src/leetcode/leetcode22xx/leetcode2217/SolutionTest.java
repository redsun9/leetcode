package leetcode.leetcode22xx.leetcode2217;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        for (int i = 1; i < 10; i++) assertEquals(i, Solution.kthPalindrome(i, 1));
    }

    @Test
    void test2() {
        for (int i = 1; i < 10; i++) assertEquals(i * 11, Solution.kthPalindrome(i, 2));
    }
}