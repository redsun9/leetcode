package help_requests.palindrome_four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void solve3() {
        assertFalse(Solution.solve3(new int[]{1, 1}));
        assertFalse(Solution.solve3(new int[]{1, 1, 2}));
        assertFalse(Solution.solve3(new int[]{1, 2, 2}));
        assertFalse(Solution.solve3(new int[]{1, 2, 3}));
        assertTrue(Solution.solve3(new int[]{1, 2, 1}));
        assertTrue(Solution.solve3(new int[]{1, 2, 2, 1}));
        assertTrue(Solution.solve3(new int[]{1, 2, 2, 2}));
        assertTrue(Solution.solve3(new int[]{1, 1, 1}));
        assertTrue(Solution.solve3(new int[]{1, 2, 3, 3, 4, 1}));
        assertFalse(Solution.solve3(new int[]{1, 1, 2, 2, 3, 3, 4, 5}));
    }

    @Test
    void solve4() {
        assertFalse(Solution.solve4(new int[]{1, 1}));
        assertFalse(Solution.solve4(new int[]{1, 1, 2}));
        assertFalse(Solution.solve4(new int[]{1, 2, 2}));
        assertFalse(Solution.solve4(new int[]{1, 2, 3}));
        assertFalse(Solution.solve4(new int[]{1, 2, 1}));
        assertTrue(Solution.solve4(new int[]{1, 2, 2, 1}));
        assertFalse(Solution.solve4(new int[]{1, 2, 2, 2}));
        assertFalse(Solution.solve4(new int[]{1, 1, 1}));
        assertTrue(Solution.solve4(new int[]{1, 2, 3, 3, 4, 1}));
        assertFalse(Solution.solve4(new int[]{1, 1, 2, 2, 3, 3, 4, 5}));
        assertTrue(Solution.solve4(new int[]{1, 1, 1, 2, 2, 3, 4, 1}));
    }

    @Test
    void solve5() {
        assertFalse(Solution.solve5(new int[]{1, 1}));
        assertFalse(Solution.solve5(new int[]{1, 1, 2}));
        assertFalse(Solution.solve5(new int[]{1, 2, 2}));
        assertFalse(Solution.solve5(new int[]{1, 2, 3}));
        assertFalse(Solution.solve5(new int[]{1, 2, 1}));
        assertFalse(Solution.solve5(new int[]{1, 2, 2, 1}));
        assertFalse(Solution.solve5(new int[]{1, 2, 2, 2}));
        assertFalse(Solution.solve5(new int[]{1, 1, 1}));
        assertFalse(Solution.solve5(new int[]{1, 2, 3, 3, 4, 1}));
        assertFalse(Solution.solve5(new int[]{1, 1, 2, 2, 3, 3, 4, 5}));
        assertFalse(Solution.solve5(new int[]{1, 1, 1, 2, 2, 3, 4, 1}));
        assertTrue(Solution.solve5(new int[]{1, 2, 3, 2, 1}));
        assertTrue(Solution.solve5(new int[]{1, 2, 3, 2, 2, 4, 3, 1}));
    }
}