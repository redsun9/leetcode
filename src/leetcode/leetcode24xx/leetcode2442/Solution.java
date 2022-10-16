package leetcode.leetcode24xx.leetcode2442;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (long num : nums) {
            set.add(num);
            set.add(reverse(num));
        }
        return set.size();

    }

    private static long reverse(long n) {
        long ans = 0;
        while (n != 0) {
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }
}
