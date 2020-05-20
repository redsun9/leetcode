package leetcode.leetcode14xx.leetcode1439;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {

    @Test
    void test() {
        int[][] mat = {{1, 3, 11}, {2, 4, 6}};
        Solution2 s = new Solution2();
        assertEquals(17, s.kthSmallest(mat, 9));
    }
}