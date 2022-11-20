package leetcode.leetcode24xx.leetcode2467;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob = 3;
        int[] amount = {-2, 4, 2, -4, 6};
        assertEquals(6, new Solution().mostProfitablePath(edges, bob, amount));
    }

    @Test
    void test2() {
        int[][] edges = {{0, 2}, {0, 5}, {1, 3}, {1, 5}, {2, 4}};
        int bob = 4;
        int[] amount = {5018, 8388, 6224, 3466, 3808, 3456};
        assertEquals(20328, new Solution().mostProfitablePath(edges, bob, amount));
    }
}