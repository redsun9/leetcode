package leetcode.leetcode6xx.leetcode621;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void leastInterval() {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        assertEquals(16, new Solution().leastInterval(tasks, 2));

    }
}