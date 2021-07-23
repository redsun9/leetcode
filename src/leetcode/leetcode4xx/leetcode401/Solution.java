package leetcode.leetcode4xx.leetcode401;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        int[] bc = new int[60];
        for (int i = 0; i < 60; i++) bc[i] = Integer.bitCount(i);
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (bc[hour] + bc[minute] == turnedOn) ans.add(String.format("%d:%02d", hour, minute));
            }
        }
        return ans;
    }
}
