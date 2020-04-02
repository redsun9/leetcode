package leetcode.leetcode13xx.leetcode1370;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void sortString() {
        Solution solution = new Solution();
        assertEquals("abccbaabccba", solution.sortString("aaaabbbbcccc"));
        assertEquals("art", solution.sortString("rat"));
        assertEquals("cdelotee", solution.sortString("leetcode"));
        assertEquals("ggggggg", solution.sortString("ggggggg"));
        assertEquals("ops", solution.sortString("spo"));

    }
}