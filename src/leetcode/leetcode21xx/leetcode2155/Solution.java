package leetcode.leetcode21xx.leetcode2155;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int numberOfOnes = 0, n = nums.length;
        for (int num : nums) if (num == 1) numberOfOnes++;

        int max = numberOfOnes, tmp = numberOfOnes;
        for (int num : nums) {
            if (num == 0) max = Math.max(max, ++tmp);
            else tmp--;
        }

        List<Integer> ans = new ArrayList<>();
        tmp = numberOfOnes;
        if (tmp == max) ans.add(0);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (++tmp == max) ans.add(i + 1);
            } else tmp--;
        }
        return ans;
    }
}
