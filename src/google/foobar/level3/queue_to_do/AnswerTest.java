package google.foobar.level3.queue_to_do;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {
    @Test
    void test1() {
        assertEquals(2, dummyAnswer(0, 3));
        assertEquals(2, Answer.answer(0, 3));
    }

    @Test
    void test2() {
        assertEquals(14, dummyAnswer(17, 4));
        assertEquals(14, Answer.answer(17, 4));
    }

    @Test
    void test3() {
        assertEquals(4, dummyAnswer(6, 5));
        assertEquals(4, Answer.answer(6, 5));
    }

    @Test
    @Disabled
    void testQueueToDo() throws InterruptedException {
        StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    return new TestData(
                            random.nextInt(0, 1_000),
                            random.nextInt(1, 1_000)
                    );
                },
                testData -> dummyAnswer(testData.start, testData.length),
                testData -> Answer.answer(testData.start, testData.length),
                100_000
        );
    }

    @Test
    @Disabled
    void testXorOfArithmeticProgression() throws InterruptedException {
        StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    return new Triple(
                            random.nextInt(0, 1_000),
                            random.nextInt(0, 1_000),
                            random.nextInt(0, 1_000)
                    );
                },
                triple -> dummyXorOfArithmeticProgression(triple.a, triple.d, triple.n),
                triple -> Answer.xorOfArithmeticProgression(triple.a, triple.d, triple.n),
                100_000
        );
    }


    // dummy brute-force solution
    public static int dummyAnswer(int start, int length) {
        int ans = 0;
        for (int i = 0, startOfRow = start; i < length; i++, startOfRow += length) {
            for (int j = 0, val = startOfRow; i + j < length; j++, val++) ans ^= val;
        }
        return ans;
    }

    private static int dummyXorOfArithmeticProgression(int a, int d, int n) {
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= a;
            a += d;
        }
        return ans;
    }

    private record Triple(int a, int d, int n) {
    }

    private record TestData(int start, int length) {
    }
}