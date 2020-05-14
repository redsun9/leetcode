package leetcode.leetcode4xx.leetcode438;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(Collections.singletonList(1), solution.findAnagrams("baa", "aa"));
    }
}