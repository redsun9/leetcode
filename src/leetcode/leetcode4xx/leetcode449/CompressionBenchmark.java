package leetcode.leetcode4xx.leetcode449;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class CompressionBenchmark {
    private final int[] testLengths = {10, 100, 1000, 10000};
    private final int testNumber = 10000;

    @Test
    @Disabled
    void testBalanced() {
        Codec1 codec1 = new Codec1();
        for (int testLength : testLengths) {
            AtomicLong counter = new AtomicLong();
            IntStream.range(0, testNumber).forEach(t -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                TreeNode expected = LeetcodeUtils.generateBalancedTree(0, 10000, testLength, random);
                counter.addAndGet(codec1.serialize(expected).length());
            });
            System.out.println(testLength + " - " + counter.get() / (double) testNumber / (double) testLength);
        }
    }

    @Test
    @Disabled
    void testDegenerated() {
        Codec1 codec1 = new Codec1();
        for (int testLength : testLengths) {
            AtomicLong counter = new AtomicLong();
            IntStream.range(0, testNumber).forEach(t -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                TreeNode expected = LeetcodeUtils.generateDegenerateTree(0, 10000, testLength, random);
                counter.addAndGet(codec1.serialize(expected).length());
            });
            System.out.println(testLength + " - " + counter.get() / (double) testNumber / (double) testLength);
        }
    }

    @Test
    @Disabled
    void testRandom() {
        Codec1 codec1 = new Codec1();
        for (int testLength : testLengths) {
            AtomicLong counter = new AtomicLong();
            IntStream.range(0, testNumber).forEach(t -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                TreeNode expected = LeetcodeUtils.generateRandomTree(0, 10000, testLength, random);
                counter.addAndGet(codec1.serialize(expected).length());
            });
            System.out.println(testLength + " - " + counter.get() / (double) testNumber / (double) testLength);
        }
    }
}
