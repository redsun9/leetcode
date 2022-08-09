package leetcode.leetcode23xx.leetcode2359;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0, node2 = 1;
        int expected = 2;
        assertEquals(expected, new Solution().closestMeetingNode(edges, node1, node2));
    }

    @Test
    void test2() {
        int[] edges = {1, 2, -1};
        int node1 = 0, node2 = 2;
        int expected = 2;
        assertEquals(expected, new Solution().closestMeetingNode(edges, node1, node2));
    }
}