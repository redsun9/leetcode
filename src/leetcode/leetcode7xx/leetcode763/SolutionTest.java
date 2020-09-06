package leetcode.leetcode7xx.leetcode763;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void partitionLabels() {
        assertEquals(List.of(9, 7, 8), new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
}