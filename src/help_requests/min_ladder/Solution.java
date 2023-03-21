package help_requests.min_ladder;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public static int minLadder(int[] heights, int k) {
        int n = heights.length;
        int ans = heights[k];
        for (int i = k - 1, tmp = 0; i >= 0; i--) {
            tmp = max(tmp, Math.abs(heights[i] - heights[i + 1]));
            ans = min(ans, max(tmp, heights[i]));
        }
        for (int i = k + 1, tmp = 0; i < n; i++) {
            tmp = max(tmp, Math.abs(heights[i] - heights[i - 1]));
            ans = min(ans, max(tmp, heights[i]));
        }
        return ans;
    }

    public static int minLadder(Iterable<Integer> heights, int k) {
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int tmp = Integer.MAX_VALUE;
        int prev = 0;
        for (Integer height : heights) {
            if (i <= k) tmp = min(max(tmp, Math.abs(height - prev)), height);
            if (i == k) {
                ans = tmp;
                tmp = 0;
            }
            if (i > k) {
                tmp = max(tmp, Math.abs(height - prev));
                ans = min(ans, max(tmp, height));
            }
            prev = height;
            i++;
        }
        return ans;
    }
}
