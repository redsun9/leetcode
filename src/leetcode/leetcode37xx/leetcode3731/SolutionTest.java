package leetcode.leetcode37xx.leetcode3731;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void findMissingElements() {
        assertEquals(List.of(3), new Solution().findMissingElements(new int[]{1, 4, 2, 5}));
        assertEquals(List.of(3), new Solution2().findMissingElements(new int[]{1, 4, 2, 5}));

        assertEquals(List.of(2, 3, 4), new Solution().findMissingElements(new int[]{1, 5}));
        assertEquals(List.of(2, 3, 4), new Solution2().findMissingElements(new int[]{1, 5}));
    }
}