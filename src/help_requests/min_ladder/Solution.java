package help_requests.min_ladder;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public static int minLadder(int[] heights, int k) {
        int n = heights.length;
        int ans = heights[k];
        for (int i = k - 1, maxDiff = 0; i >= 0; i--) {
            maxDiff = max(maxDiff, Math.abs(heights[i] - heights[i + 1]));
            ans = min(ans, max(maxDiff, heights[i]));
        }
        for (int i = k + 1, maxDiff = 0; i < n; i++) {
            maxDiff = max(maxDiff, Math.abs(heights[i] - heights[i - 1]));
            ans = min(ans, max(maxDiff, heights[i]));
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

    public static int[] minLadder(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        for (int i = 0, prevAns = 0, prevHeight = 0; i < n; i++) {
            ans[i] = min(heights[i], max(prevAns, Math.abs(heights[i] - prevHeight)));
            prevAns = ans[i];
            prevHeight = heights[i];
        }
        for (int i = n - 1, prevAns = 0, prevHeight = 0; i >= 0; i--) {
            ans[i] = min(ans[i], min(heights[i], max(prevAns, Math.abs(heights[i] - prevHeight))));
            prevAns = ans[i];
            prevHeight = heights[i];
        }
        return ans;
    }
}
