package leetcode.leetcode28xx.leetcode2848;

import java.util.Comparator;
import java.util.List;

public class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(List::getFirst));

        int ans = 0, prevStart = 0, prevEnd = -1;
        for (List<Integer> list : nums) {
            int start = list.get(0);
            int end = list.get(1);
            if (start > prevEnd) {
                prevStart = start;
                prevEnd = end;
                ans += prevEnd - prevStart + 1;
            } else if (end > prevEnd) {
                ans += end - prevEnd;
                prevEnd = end;
            }
        }
        return ans;
    }
}
