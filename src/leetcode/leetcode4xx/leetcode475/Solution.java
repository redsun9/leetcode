package leetcode.leetcode4xx.leetcode475;

import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) return 0;
        Arrays.sort(heaters);
        int n = heaters.length;
        int maxLen = 0;
        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -pos - 1;
                int tmp = Integer.MAX_VALUE;
                if (pos > 0) tmp = Math.min(tmp, house - heaters[pos - 1]);
                if (pos < n) tmp = Math.min(tmp, heaters[pos] - house);
                maxLen = Math.max(maxLen, tmp);
            }
        }
        return maxLen;
    }
}
