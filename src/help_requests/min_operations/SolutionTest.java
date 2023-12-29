package help_requests.min_operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minOperations() {
        assertEquals(3L, Solution.minOperations(new int[]{2, 3, 0, 0, 2}, 4));
    }
}