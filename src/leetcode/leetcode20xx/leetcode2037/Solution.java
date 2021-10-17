package leetcode.leetcode20xx.leetcode2037;

import java.util.Arrays;

public class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0, n = seats.length;
        for (int i = 0; i < n; i++) ans += Math.abs(seats[i] - students[i]);
        return ans;
    }
}
