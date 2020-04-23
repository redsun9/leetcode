package leetcode.leetcode6xx.leetcode691;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(
                3,
                solution.minStickers(
                        new String[]{"with", "example", "science"},
                        "thehat"
                ));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertEquals(
                4,
                solution.minStickers(
                        new String[]{"heavy", "claim", "seven", "set", "had", "it", "dead", "jump", "design", "question", "sugar", "dress", "any", "special", "ground", "huge", "use", "busy", "prove", "there", "lone", "window", "trip", "also", "hot", "choose", "tie", "several", "be", "that", "corn", "after", "excite", "insect", "cat", "cook", "glad", "like", "wont", "gray", "especially", "level", "when", "cover", "ocean", "try", "clean", "property", "root", "wing"},
                        "travelbell"
                ));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertEquals(
                5,
                solution.minStickers(
                        new String[]{"a", "enemy", "material", "whose", "twenty", "describe", "magnet", "put", "hundred", "discuss"},
                        "separatewhich"
                ));
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testRandom() {
        final Solution solution = new Solution();
        final int numberOfTests = 1000;
        final int minN = 3, maxN = 10;
        final int minLength = 3, maxLength = 5;
        final int minTimes = 0, maxTimes = 3;
        IntStream.range(0, numberOfTests).forEach(x -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            final int n = minN + random.nextInt(maxN - minN + 1);
            StringBuilder sb = new StringBuilder(n * maxLength);
            String[] stickers = new String[n];
            int upperBound = 0;
            for (int i = 0; i < n; i++) {
                char[] chars = new char[minLength + random.nextInt(maxLength - minLength + 1)];
                for (int j = 0; j < chars.length; j++) {
                    chars[j] = (char) ('0' + random.nextInt(10));
                }
                stickers[i] = new String(chars);
                int times = random.nextInt(minTimes, maxTimes + 1);
                upperBound += times;
                for (int j = 0; j < times; j++) {
                    sb.append(stickers[i]);
                }
            }
            int res = solution.minStickers(stickers, sb.toString());
            assertTrue(res >= 0);
            assertTrue(upperBound >= res);
        });
    }
}