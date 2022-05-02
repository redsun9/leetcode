package leetcode.leetcode22xx.leetcode2261;

import java.util.ArrayList;
import java.util.List;

// Trie solution
// O(n^2) using O(n^2) space
public class Solution {
    private static final int MAX_P = 200;

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        List<int[]> child = new ArrayList<>();
        child.add(new int[MAX_P + 1]);
        int nxt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i, count = 0, node = 0; j < n; j++) {
                int c = nums[j];
                if (c % p == 0) if (count++ == k) break;
                if (child.get(node)[c] == 0) {
                    child.get(node)[c] = nxt++;
                    child.add(new int[MAX_P + 1]);
                }
                node = child.get(node)[c];
            }
        }
        return child.size() - 1;
    }
}
