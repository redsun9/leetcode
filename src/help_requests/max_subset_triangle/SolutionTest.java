package help_requests.max_subset_triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(30, Solution.maxSubset(new int[]{4, 5, 6, 7, 8}));
    }

    @Test
    void test2() {
        assertEquals(3011, Solution.maxSubset(new int[]{4, 5, 6, 7, 8, 1000, 1001, 1002}));
    }

    @Test
    void test3() {
        assertEquals(12, Solution.maxSubset(new int[]{3, 2, 5, 4, 1}));
    }
}