package leetcode.leetcode21xx.leetcode2162;

public class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minutes = targetSeconds / 60, seconds = targetSeconds % 60;
        int ans = Integer.MAX_VALUE;
        if (minutes < 100) ans = count(startAt, moveCost, pushCost, minutes, seconds);
        if (seconds < 40 && minutes != 0) {
            ans = Math.min(ans, count(startAt, moveCost, pushCost, minutes - 1, seconds + 60));
        }
        return ans;
    }

    private static int count(int curPosition, int moveCost, int pushCost, int minutes, int seconds) {
        int[] arr = {minutes / 10, minutes % 10, seconds / 10, seconds % 10};
        int ans = 0;
        boolean started = false;
        for (int i = 0; i < 4; i++) {
            if (started || arr[i] != 0) {
                if (arr[i] != curPosition) ans += moveCost;
                curPosition = arr[i];
                ans += pushCost;
                started = true;
            }
        }
        return ans;
    }
}
