package help_requests.iluha_equation;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    @Test
    void solveForB() throws InterruptedException {
        assertTrue(StressTester.constructionStressTest(
                SolutionTest::generate,
                test -> Solution.solveForB(test[0], test[2], test[3]),
                SolutionTest::validateSolveForB,
                1_000_000,
                1,
                10_000
        ));
    }

    @Test
    void solveForA() throws InterruptedException {
        assertTrue(StressTester.constructionStressTest(
                SolutionTest::generate,
                test -> Solution.solveForA(test[1], test[2], test[3]),
                SolutionTest::validateSolveForA,
                1_000_000,
                1,
                10_000
        ));
    }

    private static int[] generate(long seed) {
        Random random = new Random(seed + 1);
        int bound = 1000;
        int a = 0, b = 0, c = 0, d = 0;
        while (d == 0) {
            a = 1 + random.nextInt(bound);
            b = 1 + random.nextInt(bound);
            c = 1 + random.nextInt(bound);
            d = 997 * b * c / (1000 * a + 997 * c);
        }
        return new int[]{a, b, c, d};
    }

    private static boolean validateSolveForB(int[] test, int[] solution) {
        if (solution == null) return false;
        int a = test[0], c = test[2], expected = test[3];
        if (test[1] < solution[0] || test[1] > solution[1]) return false;
        int start = solution[0], end = solution[1];
        for (int i = start; i <= end; i++) {
            if (expected != 997 * i * c / (1000 * a + 997 * c)) return false;
        }
        return true;
    }

    private static boolean validateSolveForA(int[] test, int[] solution) {
        if (solution == null) return false;
        int b = test[1], c = test[2], expected = test[3];
        if (test[0] < solution[0] || test[0] > solution[1]) return false;
        int start = solution[0], end = solution[1];
        for (int i = start; i <= end; i++) {
            if (expected != 997 * b * c / (1000 * i + 997 * c)) return false;
        }
        return true;
    }
}