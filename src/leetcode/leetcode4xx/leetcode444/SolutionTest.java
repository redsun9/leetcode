package leetcode.leetcode4xx.leetcode444;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] org = {1, 2, 3};
        int[][] seqs = {{1, 2}, {1, 3}};
        assertFalse(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test2() {
        int[] org = {1, 2, 3};
        int[][] seqs = {{1, 2}};
        assertFalse(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test3() {
        int[] org = {1, 2, 3};
        int[][] seqs = {{1, 2}, {1, 3}, {2, 3}};
        assertTrue(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test4() {
        int[] org = {4, 1, 5, 2, 6, 3};
        int[][] seqs = {{5, 2, 6, 3}, {4, 1, 5, 2}};
        assertTrue(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test5() {
        int[] org = {1};
        int[][] seqs = {{}, {1}, {}};
        assertTrue(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test6() {
        int[] org = {1, 2};
        int[][] seqs = {{2}, {1}, {}};
        assertFalse(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test7() {
        int[] org = {};
        int[][] seqs = {{}, {}, {}};
        assertTrue(new Solution().sequenceReconstruction(org, seqs));
    }

    @Test
    void test8() {
        int[] org = {1};
        int[][] seqs = {};
        assertFalse(new Solution().sequenceReconstruction(org, seqs));
    }
}