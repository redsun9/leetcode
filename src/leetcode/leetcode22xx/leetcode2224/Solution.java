package leetcode.leetcode22xx.leetcode2224;

public class Solution {
    public int convertTime(String current, String correct) {
        int diffHour = (correct.charAt(0) - current.charAt(0)) * 10 + (correct.charAt(1) - current.charAt(1));
        int diffMinute = (correct.charAt(3) - current.charAt(3)) * 10 + (correct.charAt(4) - current.charAt(4));
        if (diffMinute < 0) {
            diffHour--;
            diffMinute += 60;
        }
        if (diffHour < 0) diffHour += 24;
        int ans = diffHour;
        ans += diffMinute / 15;
        diffMinute %= 15;
        ans += diffMinute / 5 + diffMinute % 5;
        return ans;
    }
}
