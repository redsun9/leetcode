package leetcode.leetcode14xx.leetcode1423;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        assertEquals(12, solution.maxScore(cardPoints, 3));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        int[] cardPoints = {2, 2, 2};
        assertEquals(4, solution.maxScore(cardPoints, 2));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        int[] cardPoints = {9, 7, 7, 9, 7, 7, 9};
        assertEquals(55, solution.maxScore(cardPoints, 7));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        int[] cardPoints = {1, 1000, 1};
        assertEquals(1, solution.maxScore(cardPoints, 1));
    }

    @Test
    void test5() {
        Solution solution = new Solution();
        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        assertEquals(202, solution.maxScore(cardPoints, 3));
    }


}