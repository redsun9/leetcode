package leetcode.leetcode5xx.leetcode539;

import java.util.List;

public class Solution {
    public static final int minutesInDay = 24 * 60;

    private static int getTime(String time) {
        int hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int minute = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
        return hour * 60 + minute;
    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] b = new boolean[minutesInDay];
        int lowestTime = minutesInDay;
        int highestTime = 0;
        for (String s : timePoints) {
            int time = getTime(s);
            if (b[time]) return 0;
            b[time] = true;
            lowestTime = Math.min(lowestTime, time);
            highestTime = Math.max(highestTime, time);
        }
        int ans = minutesInDay + lowestTime - highestTime;
        if (ans == 1) return 1;
        int last = -minutesInDay, diff;
        for (int i = 0; i < minutesInDay; i++) {
            if (b[i]) {
                diff = i - last;
                if (diff < ans) {
                    ans = diff;
                    if (diff == 1) return 1;
                }
                last = i;
            }
        }
        return ans;
    }

}
