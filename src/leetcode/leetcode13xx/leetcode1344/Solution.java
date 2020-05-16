package leetcode.leetcode13xx.leetcode1344;

public class Solution {
    public double angleClock(int hour, int minutes) {
        double mHand = minutes * 360.0f / 60;
        double hHand = hour * 360.0f / 12 + minutes * 360.0f / 12 / 60;
        double diff = Math.abs(mHand - hHand);
        return Math.min(diff, 360 - diff);
    }
}
