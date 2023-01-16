package help_requests.max_walking_odd_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] mat = {
                {1, 15, 2},
                {9, 7, 5},
                {9, 2, 4},
                {6, 9, -1}
        };
        assertEquals(39, Solution.maxOddSum(mat));
    }
}