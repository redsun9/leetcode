package leetcode.leetcode4xx.leetcode449;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static leetcode.tools.LeetcodeUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 10000;
    private final int TESTS_PER_SUITE = 100;
    private final int[] testLengths = {10, 100, 1000, 10000};

    @Test
    void test1() {
        Integer[] arr = {2, 1, 3};
        TreeNode expected = LeetcodeUtils.initializeTree(arr);
        Codec1 codec1 = new Codec1();
        assertEquals(expected, codec1.deserialize(codec1.serialize(expected)));
    }

    @Test
    void test2() {
        Integer[] arr = {2};
        TreeNode expected = LeetcodeUtils.initializeTree(arr);
        Codec1 codec1 = new Codec1();
        assertEquals(expected, codec1.deserialize(codec1.serialize(expected)));
    }

    @Test
    void test3() {
        TreeNode expected = null;
        Codec1 codec1 = new Codec1();
        assertEquals(expected, codec1.deserialize(codec1.serialize(expected)));
    }

    @Test
    void testBalanced() {
        Codec1 codec1 = new Codec1();
        IntStream.range(0, TESTS_PER_SUITE).forEach(t -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int testLength : testLengths) {
                TreeNode expected = generateBalancedTree(MIN_VALUE, MAX_VALUE, testLength, random);
                assertEquals(expected, codec1.deserialize(codec1.serialize(expected)));
            }
        });
    }

    @Test
    void testDegenerated() {
        Codec1 codec1 = new Codec1();
        IntStream.range(0, TESTS_PER_SUITE).forEach(t -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int testLength : testLengths) {
                TreeNode expected = generateDegenerateTree(MIN_VALUE, MAX_VALUE, testLength, random);
                assertEquals(expected, codec1.deserialize(codec1.serialize(expected)));
            }
        });
    }

    @Test
    void testRandom() {
        Codec1 codec1 = new Codec1();
        IntStream.range(0, TESTS_PER_SUITE).forEach(t -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int testLength : testLengths) {
                TreeNode expected = generateRandomTree(MIN_VALUE, MAX_VALUE, testLength, random);
                assertEquals(expected, codec1.deserialize(codec1.serialize(expected)));
            }
        });
    }
}