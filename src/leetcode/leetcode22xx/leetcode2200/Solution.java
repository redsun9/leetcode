package leetcode.leetcode22xx.leetcode2200;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0, l = 0, sumL = 0, r = 0, sumR = 0; i < n; i++) {
            while (r < n && i + k >= r) if (nums[r++] == key) sumR++;
            if (l + k < i) if (nums[l++] == key) sumL++;
            if (sumR != sumL) ans.add(i);
        }
        return ans;
    }
}
