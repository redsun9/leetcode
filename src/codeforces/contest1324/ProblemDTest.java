package codeforces.contest1324;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemDTest {

    @Test
    @org.junit.jupiter.api.Disabled
    void solution() {
        IntStream.range(0, 10).parallel().forEach(__ -> {
            Random random = new Random();
            int[] a = new int[200000 + random.nextInt(100)];
            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(2_000_000_001) - 1_000_000_000;
            }
            long expected = 0;
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] + a[j] > 0) expected++;
                }
            }
            assertEquals(expected, ProblemD.solution(a));
        });
    }
}