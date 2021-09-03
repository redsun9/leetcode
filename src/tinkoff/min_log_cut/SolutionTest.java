package tinkoff.min_log_cut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {7, 9};
        assertEquals(4, Solution.solve(arr, 3));
    }
}