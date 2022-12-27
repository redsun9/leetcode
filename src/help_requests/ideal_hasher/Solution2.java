package help_requests.ideal_hasher;

import java.util.Arrays;
import java.util.BitSet;
import java.util.IntSummaryStatistics;
import java.util.Random;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class Solution2 {
    public static int findS(int[] nums) {
        int s = nums.length;
        while (!check(nums, s)) s++;
        return s;
    }

    private static boolean check(int[] nums, int s) {
        BitSet set = new BitSet(s);
        for (int num : nums) {
            int mod = num % s;
            if (mod < 0) mod += s;
            if (set.get(mod)) return false;
            set.set(mod);
        }
        return true;
    }

    public static void main(String[] args) {
        int numberOfTests = 10_000;
        int kMin = 2, kMax = 100;
        for (int k = kMin; k <= kMax; k++) {
            IntSummaryStatistics stats = new IntSummaryStatistics();
            for (int i = 0; i < numberOfTests; i++) stats.accept(findS(generateUnique(k)));
            System.out.println("k = " + k + ", stats = " + stats);
        }
    }

    private static int[] generateUnique(int k) {
        Random random = new Random();
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
}
