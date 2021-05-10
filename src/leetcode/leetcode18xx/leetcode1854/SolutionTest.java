package leetcode.leetcode18xx.leetcode1854;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] logs = {{1993, 1999}, {2000, 2010}};
        assertEquals(1993, new Solution().maximumPopulation(logs));
    }

    @Test
    void test2() {
        int[][] logs = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        assertEquals(1960, new Solution().maximumPopulation(logs));
    }
}