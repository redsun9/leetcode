package leetcode.leetcode37xx.leetcode3731;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean[] set = new boolean[101];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set[num] = true;
        }
        List<Integer> ans = new ArrayList<>(99);
        for (int i = min + 1; i < max; i++) {
            if (!set[i]) ans.add(i);
        }
        return ans;
    }
}
