package leetcode.leetcode29xx.leetcode2903;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int minVal = MAX_VALUE, maxVal = MIN_VALUE, minIdx = -1, maxIdx = -1, n = nums.length;
        for (int i = 0, j = indexDifference; j < n; i++, j++) {
            int numI = nums[i];
            if (numI < minVal) {
                minVal = numI;
                minIdx = i;
            }
            if (numI > maxVal) {
                maxVal = numI;
                maxIdx = i;
            }

            int numJ = nums[j];
            if (numJ - valueDifference >= minVal) return new int[]{minIdx, j};
            if (numJ + valueDifference <= maxVal) return new int[]{maxIdx, j};
        }
        return new int[]{-1, -1};
    }
}
