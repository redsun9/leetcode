package leetcode.leetcode8xx.leetcode843;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class SolutionTest {

    @Test
    @org.junit.jupiter.api.Disabled
    void testProbabilityOfSuccess() {
        //97852
        //98617
        //87726
        Random random = new Random(0);
        final int numberOfTests = 100;
        final int m = 1000;
        final int n = 10;
        int maxTries = 10;
        String[][] tests = getTestStrings(random, numberOfTests, m, n);
        Solution[] solutions = {
                new Solution(new InformationPicker(), maxTries),
                new Solution(new InformationPicker2(), maxTries),
                new Solution(new RandomPicker(), maxTries)
        };
        for (Solution solution : solutions) {
            AtomicInteger successCount = new AtomicInteger(0);
            IntStream.range(0, numberOfTests).parallel().forEach(i -> {
                for (int j = 0; j < m; j++) {
                    String word = tests[i][j];
                    AtomicBoolean success = new AtomicBoolean(false);
                    AtomicInteger guesses = new AtomicInteger(0);
                    Master master = getMaster(word, () -> success.set(true), guesses::incrementAndGet);
                    solution.findSecretWord(tests[i], master);
                    if (success.get()) successCount.incrementAndGet();
                }
            });
            System.out.println(successCount);
        }
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testEffectiveness() {
        //714413
        //708735
        //800371
        Random random = new Random(0);
        final int numberOfTests = 100;
        final int m = 1000;
        final int n = 10;
        int maxTries = 1000;
        String[][] tests = getTestStrings(random, numberOfTests, m, n);
        Solution[] solutions = {
                new Solution(new InformationPicker(), maxTries),
                new Solution(new InformationPicker2(), maxTries),
                new Solution(new RandomPicker(), maxTries)
        };
        for (Solution solution : solutions) {
            AtomicInteger tryCount = new AtomicInteger(0);
            IntStream.range(0, numberOfTests).parallel().forEach(i -> {
                for (int j = 0; j < m; j++) {
                    String word = tests[i][j];
                    Master master = getMaster(word, () -> {
                    }, tryCount::incrementAndGet);
                    solution.findSecretWord(tests[i], master);
                }
            });
            System.out.println(tryCount);
        }
    }

    private static String[][] getTestStrings(Random random, int numberOfTests, int m, int n) {
        String[][] tests = new String[numberOfTests][m];
        char[] chars = new char[n];
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    chars[k] = (char) ('a' + random.nextInt(26));
                }
                tests[i][j] = new String(chars);
            }
        }
        return tests;
    }

    private static Master getMaster(String word, Runnable onSuccess, Runnable onTry) {
        return x -> {
            onTry.run();
            if (word.equals(x)) {
                onSuccess.run();
                return word.length();
            } else {
                int count = 0;
                for (int k = 0; k < word.length(); k++) {
                    if (word.charAt(k) == x.charAt(k)) count++;
                }
                return count;
            }
        };
    }
}
