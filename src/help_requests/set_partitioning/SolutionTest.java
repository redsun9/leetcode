package help_requests.set_partitioning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, Solution.numberOfPartitions(new int[]{1}));
        assertEquals(2, Solution.numberOfPartitions(new int[]{1, 1}));
        assertEquals(235, Solution.numberOfPartitions(new int[]{2, 2, 3}));
        assertEquals(80955, Solution.numberOfPartitions(new int[]{2, 2, 3, 4}));

    }
}