package leetcode.leetcode23xx.leetcode2380;

public class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int lastPos = s.length() - 1;
        while (lastPos >= 0 && s.charAt(lastPos) != '1') lastPos--;

        int waitingTime = 0, zeroCount = 0;
        char prev = '2', curr;
        for (int i = 0; i <= lastPos; i++) {
            curr = s.charAt(i);
            if (curr == '1' && prev == '1' && zeroCount != 0) waitingTime++;
            if (curr == '0' && prev == '0' && waitingTime != 0) waitingTime--;
            if (curr == '0') zeroCount++;
            prev = curr;
        }
        return zeroCount + waitingTime;
    }
}
