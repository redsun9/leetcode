package help_requests.ideal_hasher;

import java.util.Arrays;
import java.util.BitSet;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("DuplicatedCode")
public class Solution3 {
    private static final int MAX_CALC = 10_000_000;
    private static final double FAIL_PROB = 1e-9;
    private static final int MAX_CALC_PER_S = 100_000;
    private static final int MAX_ROUNDS_FOR_POTENTIALLY_BAD_S = 100;
    private static final boolean RUN_TESTS_FOR_STATISTICS = true;

    public static void main(String[] args) {
        printStatistics();
    }

    private static void printStatistics() {
        int numberOfTests = 100;
        int kMin = 2, kMax = 1_000;
        for (int k = kMin; k <= kMax; k++) {
            int s = evaluateOptimalS(k);
            System.out.println("k = " + k + ", optimal s = " + s);
            if (RUN_TESTS_FOR_STATISTICS) {
                int finalK = k;
                IntSummaryStatistics statsForS = IntStream.range(0, numberOfTests).parallel().boxed()
                        .collect(Collectors.summarizingInt(t -> findS(generateUnique(finalK), s)));
                IntSummaryStatistics statsForR = IntStream.range(0, numberOfTests).parallel().boxed()
                        .collect(Collectors.summarizingInt(t -> findR(generateUnique(finalK), s)));
                System.out.println("statForS = " + statsForS);
                System.out.println("statForR = " + statsForR);
                System.out.println("potential calc amount = " + (k * statsForR.getAverage()));
                System.out.println();
            }
        }
    }

    private static int evaluateOptimalS(int n) {
        double minInvLogSuccessProb = -Math.log(1.0 - Math.pow(FAIL_PROB, (double) n / MAX_CALC));
        double logFact = 0;
        for (int i = 1; i <= n; i++) logFact -= Math.log(i);
        int s = n;
        while (logFact + n * Math.log(s) > minInvLogSuccessProb) {
            s++;
            logFact = logFact - Math.log(s) + Math.log(s - n);
        }
        return s;
    }

    private static int findS(int[] nums, int s) {
        Random random = ThreadLocalRandom.current();
        int totalRounds = 1, roundsWithCurrent = 1, n = nums.length;
        int maxRoundsWithCurrent = potentiallyBadS(s) ? MAX_ROUNDS_FOR_POTENTIALLY_BAD_S : MAX_CALC_PER_S / n;
        while (true) {
            int m = random.nextInt();
            while (((m & 1) == 0) || Math.abs(gcd(s, m)) != 1) m = random.nextInt();
            if (success(nums, s, m)) break;
            totalRounds++;
            if (roundsWithCurrent++ == maxRoundsWithCurrent) {
                s++;
                maxRoundsWithCurrent = potentiallyBadS(s) ? MAX_ROUNDS_FOR_POTENTIALLY_BAD_S : MAX_CALC_PER_S / n;
                roundsWithCurrent = 1;
            }
        }
        return s;
    }

    private static int findR(int[] nums, int s) {
        Random random = ThreadLocalRandom.current();
        int totalRounds = 1, roundsWithCurrent = 1, n = nums.length;
        int maxRoundsWithCurrent = potentiallyBadS(s) ? MAX_ROUNDS_FOR_POTENTIALLY_BAD_S : MAX_CALC_PER_S / n;
        while (true) {
            int m = random.nextInt();
            while (((m & 1) == 0) || Math.abs(gcd(s, m)) != 1) m = random.nextInt();
            if (success(nums, s, m)) break;
            totalRounds++;
            if (roundsWithCurrent++ == maxRoundsWithCurrent) {
                s++;
                maxRoundsWithCurrent = potentiallyBadS(s) ? MAX_ROUNDS_FOR_POTENTIALLY_BAD_S : MAX_CALC_PER_S / n;
                roundsWithCurrent = 1;
            }
        }
        return totalRounds;
    }

    private static boolean potentiallyBadS(int s) {
        return s % 2 == 0 || s % 3 == 0 || s % 5 == 0;
    }

    private static boolean success(int[] nums, int s, int m) {
        BitSet set = new BitSet(s);
        for (int num : nums) {
            int mod = num * m % s;
            if (mod < 0) mod += s;
            if (set.get(mod)) return false;
            set.set(mod);
        }
        return true;
    }

    private static int[] generateUnique(int k) {
        Random random = ThreadLocalRandom.current();
        int[] nums = new int[k];
        boolean hasDuplicate = true;
        while (hasDuplicate) {
            for (int i = 0; i < k; i++) nums[i] = random.nextInt();
            Arrays.sort(nums);
            hasDuplicate = false;
            for (int i = 1; i < k && !hasDuplicate; i++) hasDuplicate = nums[i - 1] == nums[i];
        }
        return nums;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
