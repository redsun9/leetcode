package leetcode.leetcode23xx.leetcode2354;

import java.util.HashSet;

@SuppressWarnings("unchecked")
public class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer>[] set = new HashSet[33];
        for (int i = 0; i < 33; i++) set[i] = new HashSet<>();
        for (int num : nums) set[Integer.bitCount(num)].add(num);

        long ans = 0;
        for (int i = 0; i < 33; i++) {
            long iSize = set[i].size();
            for (int j = i; j < 33; j++) {
                if (i + j < k) continue;
                if (i == j) ans += iSize * iSize;
                else ans += 2 * iSize * set[j].size();
            }
        }
        return ans;
    }
}
