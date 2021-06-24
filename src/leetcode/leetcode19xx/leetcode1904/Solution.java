package leetcode.leetcode19xx.leetcode1904;

public class Solution {
    private static int getTime(String time) {
        int hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int minute = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
        return hour * 60 + minute;
    }

    public int numberOfRounds(String startTime, String finishTime) {
        int start = getTime(startTime);
        int end = getTime(finishTime);
        if (end < start) end += 24 * 60;
        int startInterval = (start + 14) / 15;
        int endInterval = end / 15;
        if (endInterval <= startInterval) return 0;
        else return endInterval - startInterval;
    }
}
