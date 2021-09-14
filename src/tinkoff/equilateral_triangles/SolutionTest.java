package tinkoff.equilateral_triangles;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    @Disabled
    void testCorrectness() throws InterruptedException {
        int n = 100;
        int maxCoordinate = 100;
        int numberOfTests = 100_000;

        boolean ok = StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    Set<Solution.Point> set = new HashSet<>();
                    int[][] points = new int[n][2];
                    for (int i = 0; i < n; ) {
                        int x = random.nextInt(maxCoordinate);
                        int y = random.nextInt(maxCoordinate);
                        if (set.add(new Solution.Point(x, y))) {
                            points[i][0] = x;
                            points[i][1] = y;
                            i++;
                        }
                    }
                    return points;
                },
                Solution2::solve,
                Solution::solve,
                numberOfTests
        );
        assertTrue(ok);
    }
}