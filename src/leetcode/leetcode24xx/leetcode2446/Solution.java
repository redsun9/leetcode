package leetcode.leetcode24xx.leetcode2446;

public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String maxStart = event1[0];
        if (CharSequence.compare(maxStart, event2[0]) < 0) maxStart = event2[0];
        String minEnd = event1[1];
        if (CharSequence.compare(minEnd, event2[1]) > 0) minEnd = event2[1];
        return CharSequence.compare(maxStart, minEnd) <= 0;
    }
}
