package leetcode.leetcode17xx.leetcode1710;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final int n = 100, maxCount = 20, maxSize = 20, maxTrackSize = 1000;

    @Test
    void test1() {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        int expected = 8;
        assertEquals(expected, new Solution().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution2().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution3().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution4().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution5().maximumUnits(boxTypes, truckSize));
    }

    @Test
    void test2() {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        int expected = 91;
        assertEquals(expected, new Solution().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution2().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution3().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution4().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution5().maximumUnits(boxTypes, truckSize));
    }

    @Test
    void test3() {
        int[][] boxTypes = {{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}};
        int truckSize = 13;
        int expected = new Solution().maximumUnits(boxTypes, truckSize);
        int actual = new Solution5().maximumUnits(boxTypes, truckSize);
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    void testCorrectness4() throws InterruptedException {
        Solution4 solution4 = new Solution4();
        Solution3 solution3 = new Solution3();
        StressTester.exactStressTest(
                this::generate,
                data -> solution3.maximumUnits(data.boxTypes, data.truckSize),
                data -> solution4.maximumUnits(data.boxTypes, data.truckSize),
                1_000_000,
                1,
                100_000
        );
    }

    @Test
    @Disabled
    void testCorrectness5() throws InterruptedException {
        Solution5 solution5 = new Solution5();
        Solution3 solution3 = new Solution3();
        StressTester.exactStressTest(
                this::generate,
                data -> solution3.maximumUnits(data.boxTypes, data.truckSize),
                data -> solution5.maximumUnits(data.boxTypes, data.truckSize),
                1_000_000,
                1,
                100_000
        );
    }


    private TestData generate(long seed) {
        Random random = new Random(seed);
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = random.nextInt(1, maxCount);
            nums[i][1] = random.nextInt(1, maxSize);
        }
        return new TestData(nums, random.nextInt(1, 30));
    }

    private record TestData(int[][] boxTypes, int truckSize) {
    }
}