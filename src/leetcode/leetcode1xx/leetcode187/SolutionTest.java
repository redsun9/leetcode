package leetcode.leetcode1xx.leetcode187;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class SolutionTest {
    @Disabled
    @Test
    void perfTest() {
        //test1 - 5234434300
        //test2 - 58767013600
        //test3 - 48057791200
        final int numberOfTests = 100;
        final int lengthOfString = 10000000;
        char[] signs = {'T', 'G', 'C', 'A'};
        String[] tests = new String[numberOfTests];
        char[] tmp = new char[lengthOfString];
        Random random = new Random(0);
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < lengthOfString; j++) {
                tmp[j] = signs[random.nextInt(4)];
            }
            tests[i] = new String(tmp);
        }

        RepeatedDnaSequenceFinder[] solutions = {new Solution(), new Solution2(), new Solution3()};
        long[] timer = new long[solutions.length];
        for (int i = 0; i < solutions.length; i++) {
            RepeatedDnaSequenceFinder solution = solutions[i];
            long start = System.nanoTime();
            List<Integer> collect = Arrays.stream(tests).parallel().map(solution::findRepeatedDnaSequences)
                    .map(List::size).collect(Collectors.toList());
            Assertions.assertEquals(numberOfTests, collect.size());
            long end = System.nanoTime();
            timer[i] = end - start;
        }
        for (long l : timer) {
            System.out.println(l);
        }
    }
}