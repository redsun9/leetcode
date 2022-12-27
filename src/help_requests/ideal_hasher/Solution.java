package help_requests.ideal_hasher;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) {
        int k = 1000;
        int[] nums = generateUnique(k);

        double pFail = 1e-9;
        double probOfFailMin = 0.999;
        double probFailMax = 0.999_999_999;
        int calculateSMin = (int) (Math.pow(k, 2) / (2.0 * Math.log(1.0 / (1.0 - probFailMax))));
        int sMin = Math.max(k, calculateSMin);
        int calculatedSMax = (int) (Math.pow(k, 2) / (2.0 * Math.log(1.0 / (1.0 - probOfFailMin))));
        int sMax = Math.max(k * 3 / 2 + 1, calculatedSMax);

        double actualFailProbSMin = probOfFail(k, sMin);
        double actualFailProbSMax = probOfFail(k, sMax);


        int triesPerS = (int) (Math.ceil(Math.log(pFail) / Math.log(Math.sqrt(actualFailProbSMin * actualFailProbSMax)) / (sMax - sMin + 1)));

        System.out.println("s = [" + sMin + "; " + sMax + "]");
        System.out.println("per s = " + triesPerS);

        List<int[]> best = IntStream.rangeClosed(sMin, sMax).parallel().boxed().flatMap(s ->
                        IntStream.range(0, triesPerS).map(t -> ThreadLocalRandom.current().nextInt())
                                .mapToObj(m -> new int[]{m, s})
                )
                .filter(x -> distinct(nums, x[0], x[1]))
                .sorted(Comparator.comparingInt(x -> x[1]))
                .limit(10)
                .toList();

        for (int[] arr : best) System.out.println("s=" + arr[1] + ", m=" + arr[0]);


    }

    private static boolean distinct(int[] nums, int m, int s) {
        BitSet set = new BitSet(s);
        for (int num : nums) {
            int mod = num * m % s;
            if (mod < 0) mod += s;
            if (set.get(mod)) return false;
            set.set(mod);
        }
        return true;
    }

    private static double probOfFail(int n, int d) {
        if (n > d) return 1.0;
        double ans = 1.0;
        for (int i = 1, j = d; i <= n; i++, j--) ans = ans * j / d;
        return 1.0 - ans;
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
