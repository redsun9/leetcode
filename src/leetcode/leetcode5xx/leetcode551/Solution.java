package leetcode.leetcode5xx.leetcode551;

public class Solution {
    public boolean checkRecord(String s) {
        boolean absent = false;
        int prevLate = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (absent) return false;
                absent = true;
                prevLate = 0;
            } else if (c == 'L') {
                if (prevLate == 2) return false;
                prevLate++;
            } else prevLate = 0;
        }
        return true;
    }
}
