package leetcode.leetcode2xx.leetcode204;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void countPrimes() {
        Solution solution = new Solution();
        assertEquals(4, solution.countPrimes(10));
        assertEquals(25, solution.countPrimes(100));
        assertEquals(168, solution.countPrimes(1_000));
        assertEquals(1229, solution.countPrimes(10_000));
        assertEquals(9592, solution.countPrimes(100_000));
        assertEquals(78498, solution.countPrimes(1_000_000));
        assertEquals(664579, solution.countPrimes(10_000_000));
        assertEquals(5761455, solution.countPrimes(100_000_000));
        assertEquals(50847534, solution.countPrimes(1_000_000_000));
    }
}