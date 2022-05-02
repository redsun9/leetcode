package leetcode.leetcode22xx.leetcode2261;

import java.util.HashSet;
import java.util.Set;

// Rabin Karp solution
// O(n^2) using O(n^2) space
@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private static final int MAX_P = 200;
    private static final long base = MAX_P + 1;
    private static final long mod = 45887423068929227L;

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long hash = 0;
            for (int j = i, count = 0; j < n; j++) {
                if (nums[j] % p == 0) if (count++ == k) break;
                hash = (hash * base + nums[j]) % mod;
                set.add(hash);
            }
        }
        return set.size();
    }
}
