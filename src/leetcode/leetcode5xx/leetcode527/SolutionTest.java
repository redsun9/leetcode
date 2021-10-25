package leetcode.leetcode5xx.leetcode527;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] input = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        String[] actual = new Solution().wordsAbbreviation(input);
        String[] expected = {"l2e", "god", "internal", "me", "i6t", "interval", "inte4n", "f2e", "intr4n"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        String[] input = {"where", "there", "is", "beautiful", "way"};
        String[] actual = new Solution().wordsAbbreviation(input);
        String[] expected = {"w3e", "t3e", "is", "b7l", "way"};
        assertArrayEquals(expected, actual);
    }
}