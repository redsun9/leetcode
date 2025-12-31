package leetcode.leetcode37xx.leetcode3790;

import org.junit.jupiter.api.Test;

import java.util.Random;

class SolutionTest {

    @Test
    void minAllOneMultiple() {
        Random random = new Random();
        for (int i = 2; i < 1000; i++) {
            int t = random.nextInt(10000000) * 10 + 1;
            int expected = new Solution().minAllOneMultiple(t);
            int actual = new Solution2().minAllOneMultiple(t);
            if (actual == expected) System.out.println("Сошлось для " + t + ", " + expected);
            if (actual != expected) System.out.println("Не сошлось для " + i + ", " + expected + ", " + actual);
        }
    }

    @Test
    void test1() {
        Random random = new Random(1);
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            int t = 1_000_000_000 + random.nextInt(100_000_000) * 10 + 1;
            int expected = solution.minAllOneMultiple(t);
            sum += expected;
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 10.0);

        random = new Random(1);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int t = 1_000_000_000 + random.nextInt(100_000_000) * 10 + 1;
            int expected = solution2.minAllOneMultiple(t);
            sum += expected;
        }
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);

        System.out.println(sum);
    }
}