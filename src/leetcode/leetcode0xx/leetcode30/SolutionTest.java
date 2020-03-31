package leetcode.leetcode0xx.leetcode30;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void findSubstring() {
        Solution solution = new Solution();
        assertEquals(
                new HashSet<>(Arrays.asList(0, 9)),
                new HashSet<>(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})
                )
        );
        assertEquals(
                new HashSet<>(Arrays.asList(6, 9, 12)),
                new HashSet<>(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})
                )
        );
    }
}
