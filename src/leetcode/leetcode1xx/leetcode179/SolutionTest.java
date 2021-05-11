package leetcode.leetcode1xx.leetcode179;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {
    @Test
    void test1() {
        int[] nums = {10, 2};
        assertEquals("210", new Solution().largestNumber(nums));
        assertEquals("210", new Solution2().largestNumber(nums));
        assertEquals("210", new Solution3().largestNumber(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 30, 34, 5, 9};
        assertEquals("9534330", new Solution().largestNumber(nums));
        assertEquals("9534330", new Solution2().largestNumber(nums));
        assertEquals("9534330", new Solution3().largestNumber(nums));
    }

    @Test
    @Disabled
    void test3() {
        //counterexample to https://www.geeksforgeeks.org/arrange-given-numbers-form-biggest-number-set-2
        int[] nums = {119301, 11930};
        assertEquals("11930119301", new Solution().largestNumber(nums));
        assertEquals("11930119301", new Solution4().largestNumber(nums));
    }

    @Test
    @Disabled
    void testCorrectness() {
        int n = 2_000_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i / 2;
        String actual1 = new Solution().largestNumber(nums);
        String actual2 = new Solution2().largestNumber(nums);
        String actual3 = new Solution3().largestNumber(nums);
        assertEquals(actual1, actual2);
        assertEquals(actual1, actual3);
    }


    @Test
    @Disabled
    void testRandom() {
        int[][] tests = generateTests(1000000, 100, 1000000);
        Solution solution1 = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        Arrays.stream(tests).parallel().forEach(test -> {
            String actual1 = solution1.largestNumber(test);
            String actual2 = solution2.largestNumber(test);
            String actual3 = solution3.largestNumber(test);
            assertEquals(actual1, actual2);
            assertEquals(actual1, actual3);
        });
    }

    @Test
        //389931500
        //259045100
        //548440100
        //
        //482235400
        //190941500
        //543993800
        //
        //431881000
        //119835000
        //530067200
        //
        //476322300
        //83641300
        //436223900
        //
        //749382700
        //147537600
        //397655800
        //
        //1539746000
        //648076500
        //737909400
        //
        //9964939500
        //4359737500
        //1626109900
    @Disabled
    void testPerformance() {
        int[][] testSizes = {
                {1000000, 10},
                {100000, 100},
                {10000, 1000},
                {1000, 10000},
                {100, 100000},
                {10, 1000000},
                {1, 10000000}
        };
        for (int[] testSize : testSizes) {
            int[][] tests = generateTests(testSize[0], testSize[1], 10000);
            Solution solution1 = new Solution();
            Solution2 solution2 = new Solution2();
            Solution3 solution3 = new Solution3();

            long startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertFalse(solution1.largestNumber(test).isEmpty());
            });
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);

            startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertFalse(solution2.largestNumber(test).isEmpty());
            });
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);

            startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertFalse(solution3.largestNumber(test).isEmpty());
            });
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
            System.out.println();
        }
    }

    private int[][] generateTests(int numberOfTests, int testLength, int bound) {
        Random random = new Random(0);
        int[][] tests = new int[numberOfTests][testLength];
        for (int i = 0; i < numberOfTests; i++) {
            int[] test = tests[i];
            for (int j = 0; j < testLength; j++) {
                test[j] = random.nextInt(bound);
            }
        }
        return tests;
    }

}