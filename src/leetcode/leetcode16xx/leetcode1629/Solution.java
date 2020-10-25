package leetcode.leetcode16xx.leetcode1629;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = keysPressed.length();
        char ans = 'z';
        int maxDuration = 0;
        int prevRelease = 0;
        for (int i = 0; i < n; i++) {
            int currentRelease = releaseTimes[i];
            int duration = currentRelease - prevRelease;
            if (duration > maxDuration || duration == maxDuration && keysPressed.charAt(i) > ans) {
                maxDuration = duration;
                ans = keysPressed.charAt(i);
            }
            prevRelease = currentRelease;
        }
        return ans;
    }
}
