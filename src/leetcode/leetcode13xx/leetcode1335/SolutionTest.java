package leetcode.leetcode13xx.leetcode1335;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minDifficulty() {
        int[] jd = {6, 5, 4, 3, 2, 1};
        assertEquals(7, new Solution2().minDifficulty(jd, 2));
    }
}