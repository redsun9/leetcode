package help_requests.fibonacci_last_digit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    // k = 1, cycleLength = 60
    // k = 2, cycleLength = 300
    // k = 3, cycleLength = 1_500
    // k = 4, cycleLength = 15_000
    // k = 5, cycleLength = 150_000
    // k = 6, cycleLength = 1_500_000
    // k = 7, cycleLength = 15_000_000
    // k = 8, cycleLength = 150_000_000
    // k = 9, cycleLength = 1_500_000_000
    @Test
    void testFiboncci2() {
        assertEquals(5, Solution2.fib(1000, 1));
        assertEquals(75, Solution2.fib(1000, 2));
        assertEquals(875, Solution2.fib(1000, 3));
        assertEquals(8875, Solution2.fib(1000, 4));
        assertEquals(28875, Solution2.fib(1000, 5));
        assertEquals(228875, Solution2.fib(1000, 6));
        assertEquals(9228875, Solution2.fib(1000, 7));
        assertEquals(49228875, Solution2.fib(1000, 8));
        assertEquals(849228875, Solution2.fib(1000, 9));
    }

    @Test
    void testFibonacci3() {
        assertEquals(5, Solution3.fib(1000, 1));
        assertEquals(75, Solution3.fib(1000, 2));
        assertEquals(875, Solution3.fib(1000, 3));
        assertEquals(8875, Solution3.fib(1000, 4));
        assertEquals(28875, Solution3.fib(1000, 5));
        assertEquals(228875, Solution3.fib(1000, 6));
        assertEquals(9228875, Solution3.fib(1000, 7));
        assertEquals(49228875, Solution3.fib(1000, 8));
        assertEquals(849228875, Solution3.fib(1000, 9));
    }

    // k = 1, cycleLength = 124
    // k = 2, cycleLength = 1_240
    // k = 3, cycleLength = 12_400
    // k = 4, cycleLength = 124_000
    // k = 5, cycleLength = 1_240_000
    // k = 6, cycleLength = 12_400_000
    // k = 7, cycleLength = 124_000_000
    // k = 8, cycleLength = 1_240_000_000
    @Test
    void testTribonacci2() {
        assertEquals(4, Solution2.trib(1000, 1));
        assertEquals(84, Solution2.trib(1000, 2));
        assertEquals(384, Solution2.trib(1000, 3));
        assertEquals(1384, Solution2.trib(1000, 4));
        assertEquals(11384, Solution2.trib(1000, 5));
        assertEquals(711384, Solution2.trib(1000, 6));
        assertEquals(5711384, Solution2.trib(1000, 7));
        assertEquals(25711384, Solution2.trib(1000, 8));
    }

    @Test
    void testTribonacci3() {
        assertEquals(4, Solution3.trib(1000, 1));
        assertEquals(84, Solution3.trib(1000, 2));
        assertEquals(384, Solution3.trib(1000, 3));
        assertEquals(1384, Solution3.trib(1000, 4));
        assertEquals(11384, Solution3.trib(1000, 5));
        assertEquals(711384, Solution3.trib(1000, 6));
        assertEquals(5711384, Solution3.trib(1000, 7));
        assertEquals(25711384, Solution3.trib(1000, 8));
    }

    @Test
    void testFibonacci() {
        for (int k = 1; k <= 6; k++) {
            for (int i = 0; i < 1000; i++) {
                assertEquals(Solution.fib(i, k), Solution2.fib(i, k));
                assertEquals(Solution2.fib(i, k), Solution3.fib(i, k));
            }
        }
    }

    @Test
    void testTribonacci() {
        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i < 10000; i++) {
                assertEquals(Solution.trib(i, k), Solution2.trib(i, k));
                assertEquals(Solution.trib(i, k), Solution3.trib(i, k));
            }
        }
    }

    @Test
    void testFibonacci2() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 12, 123, 1234, 12345, 123456};
        for (int n : arr) System.out.println("fib(" + n + ") => " + Solution3.fib(n, 6));
        System.out.println();
        for (int n : arr) System.out.println("fib(" + n + ") => " + Solution3.trib(n, 6));
    }
}