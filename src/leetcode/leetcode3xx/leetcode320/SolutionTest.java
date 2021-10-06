package leetcode.leetcode3xx.leetcode320;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Set<String> expected = Set.of(
                "word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "4",
                "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3"
        );
        HashSet<String> actual = new HashSet<>(new Solution().generateAbbreviations("word"));
        assertEquals(expected, actual);
    }
}