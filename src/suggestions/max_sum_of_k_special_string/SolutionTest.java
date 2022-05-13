package suggestions.max_sum_of_k_special_string;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    @Test
    void test1() {
        Solution solution = new Solution();
        int[] arr = {-3, 2, -3, 4, 5, -13};
        assertEquals(5, solution.maxSumOfKSpecial(arr, 2));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        int[] arr = {-3, 2, -3, 4, 5, -13};
        assertEquals(-8, solution.maxSumOfKSpecial(arr, 3));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        int[] arr = {-3, 2, -3, 4, 5, -13};
        assertEquals(8, solution.maxSumOfKSpecial(arr, 1));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        int[] arr = {-3, 2, -3, 4, 5, -13};
        assertEquals(9, solution.maxSumOfKSpecial(arr, 0));
    }

    @Test
    void test5() {
        Solution solution = new Solution();
        int[] arr = {-3, -3, -3};
        assertEquals(0, solution.maxSumOfKSpecial(arr, 0));
    }

    @Test
    void test6() {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1};
        assertEquals(3, solution.maxSumOfKSpecial(arr, 0));
    }

    @Test
    void test7() {
        Solution solution = new Solution();
        int[] arr = {};
        assertEquals(0, solution.maxSumOfKSpecial(arr, 0));
    }

    @Test
    void test8() {
        Solution solution = new Solution();
        int[] arr = {-13, -33, -23};
        assertEquals(-46, solution.maxSumOfKSpecial(arr, 2));
    }

    @Test
    void test9() {
        Solution solution = new Solution();
        int[] arr = {-2, 3, -2, 4, -1};
        assertEquals(5, solution.maxSumOfKSpecial(arr, 0));
    }

    @Test
    @Disabled
    void stressTest() throws InterruptedException {
        int n = 100;
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
        StressTester.exactStressTest(
                seed -> {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    int[] arr = new int[n];
                    int c = 0, num;
                    for (int i = 0; i < n; i++) {
                        if (random.nextBoolean()) {
                            num = random.nextInt(1000);
                        } else {
                            num = -3 - 10 * random.nextInt(100);
                            c++;
                        }
                        arr[i] = num;
                    }
                    return new TestData(arr, random.nextInt(c + 1));
                },
                testData -> solution3.maxSumOfKSpecial(testData.arr, testData.k),
                testData -> solution.maxSumOfKSpecial(testData.arr, testData.k),
                1_000_000,
                1,
                100_000
        );
    }

    private record TestData(int[] arr, int k) {
    }
}