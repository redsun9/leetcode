package leetcode.leetcode37xx.leetcode3775;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void reverseWords() {
        assertEquals("cat dna mice", new Solution().reverseWords("cat and mice"));
        assertEquals("book is ecin", new Solution().reverseWords("book is nice"));
    }
}