package tinkoff.equilateral_triangles;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testCorrectness() {
        int n = 100;
        int maxCoordinate = 100;

        int numberOfTests = 100_000;

        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            Random random = ThreadLocalRandom.current();
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
            assertEquals(Solution.solve(points), Solution2.solve(points));
        });
    }
}