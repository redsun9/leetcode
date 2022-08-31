package help_requests.colour_fill;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test1() {
        int[][] mat = {{1, 1, 4}, {2, 1, 5}, {3, 2, 2}};
        assertEquals(6, Solution4.numberOfFills(mat));
        assertEquals(6, Solution.numberOfFills(mat));

    }

    @Test
    void testDFSWithRecursion() {
        int n = 1000;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], 1);
        }
        assertThrows(StackOverflowError.class, () -> Solution.numberOfFills(mat));
    }

    @Test
    void testDFSWithStack() {
        int n = 1000;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], 1);
        }
        assertDoesNotThrow(() -> Solution2.numberOfFills(mat));
    }


    @Test
    void stressTest() throws InterruptedException {
        int n = 10, k = 5;
        StressTester.exactStressTest(
                seed -> {
                    int[][] mat = new int[n][n];
                    Random random = new Random(seed);
                    for (int[] row : mat) for (int i = 0; i < n; i++) row[i] = 1 + random.nextInt(k);
                    return mat;
                },
                mat -> {
                    int[][] arr = new int[n][];
                    for (int i = 0; i < n; i++) arr[i] = Arrays.copyOf(mat[i], n);
                    return Solution3.numberOfFills(arr);
                },
                Solution4::numberOfFills,
                1_000_000
        );
    }
}