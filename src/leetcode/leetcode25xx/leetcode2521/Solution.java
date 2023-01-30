package leetcode.leetcode25xx.leetcode2521;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final int[] firstPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            for (int prime : firstPrimes) {
                if (num % prime == 0) {
                    set.add(prime);
                    while (num % prime == 0) num /= prime;
                }
                if (prime * prime >= num) break;
            }
            if (num != 1) set.add(num);
        }
        return set.size();
    }
}
