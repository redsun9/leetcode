package leetcode.leetcode4xx.leetcode484;

import leetcode.leetcode0xx.leetcode46.Solution2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import prng.XorShift64;
import stress.StressTester;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String s = "DI";
        int[] ans = new Solution().findPermutation(s);
        assertTrue(validate(s, ans));
    }

    @Test
    void test2() {
        String s = "I";
        int[] ans = new Solution().findPermutation(s);
        assertTrue(validate(s, ans));
    }

    @Test
    void test3() {
        String s = "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII";
        int[] ans = new Solution().findPermutation(s);
        assertTrue(validate(s, ans));
    }

    @Test
    void test4() {
        String s = "DDID";
        int[] ans = new Solution().findPermutation(s);
        assertTrue(validate(s, ans));
    }


    @Test
    void testForMinimum() {
        Solution solution = new Solution();
        int bits = 6; // for bits=12, (bits+1)! > Integer.MAX_VALUE
        int totalTests = 1 << bits;

        AtomicReferenceArray<int[]> expected = new AtomicReferenceArray<>(totalTests);
        int[] dummy = new int[bits + 1];
        Arrays.fill(dummy, bits + 1);
        for (int i = 0; i < totalTests; i++) expected.set(i, dummy);

        int[] nums = new int[bits + 1];
        for (int i = 0; i <= bits; i++) nums[i] = i + 1;
        List<List<Integer>> permutations = Solution2.permute(nums);

        IntStream.range(0, permutations.size()).parallel().mapToObj(permutations::get).forEach(permutation -> {
            int[] arr = permutation.stream().mapToInt(x -> x).toArray();
            int key = 0;
            for (int i = 0; i < bits; i++) if (arr[i] < arr[i + 1]) key |= 1 << i;
            while (true) {
                int[] prevVal = expected.get(key);
                if (Arrays.compare(prevVal, arr) > 0) {
                    if (expected.compareAndSet(key, prevVal, arr)) return;
                } else return;
            }
        });

        IntStream.range(0, totalTests).parallel().forEach(key -> {
            char[] arr = new char[bits];
            for (int i = 0; i < bits; i++) {
                if ((key >> i & 1) == 1) arr[i] = 'I';
                else arr[i] = 'D';
            }
            String str = new String(arr);
            int[] actual = solution.findPermutation(str);
            assertArrayEquals(expected.get(key), actual);
        });
    }


    @Test
    void testForConstraints() {
        Solution sol = new Solution();
        int bits = 12;
        int totalTests = (1 << bits);

        IntStream.range(0, totalTests).parallel().forEach(key -> {
            char[] tmp = new char[bits];
            for (int i = 0; i < bits; i++) {
                if ((key >> i & 1) == 0) tmp[i] = 'I';
                else tmp[i] = 'D';
            }
            String s = new String(tmp);
            assertTrue(validate(s, sol.findPermutation(s)));
        });
    }

    @Test
    @Disabled
    void testRandom() throws InterruptedException {
        Solution solution = new Solution();
        assertTrue(StressTester.constructionStressTest(
                seed -> {
                    long key = new XorShift64(seed).nextLong();
                    char[] s = new char[64];
                    for (int i = 0; i < 64; i++) {
                        if ((key >> i & 1) == 0) s[i] = 'I';
                        else s[i] = 'D';
                    }
                    return new String(s);
                },
                solution::findPermutation,
                SolutionTest::validate,
                10_000_000
        ));
    }

    // doesn't check minimum
    private static boolean validate(String s, int[] ans) {
        int n = s.length();
        if (ans.length != n + 1) return false;
        for (int i = 0; i < n; i++) if (s.charAt(i) == 'I' ^ ans[i] < ans[i + 1]) return false;
        boolean[] meet = new boolean[n + 1];
        for (int a : ans) {
            if (meet[a - 1]) return false;
            meet[a - 1] = true;
        }
        return true;
    }
}