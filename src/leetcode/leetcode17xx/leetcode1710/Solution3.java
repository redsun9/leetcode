package leetcode.leetcode17xx.leetcode1710;

// Count sort
public class Solution3 {
    private static final int MAX_UNIT_PER_BOX = 1000;

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[MAX_UNIT_PER_BOX + 1];
        for (int[] boxType : boxTypes) count[boxType[1]] += boxType[0];
        int ans = 0;
        for (int i = MAX_UNIT_PER_BOX; truckSize != 0 && i > 0; i--) {
            int spent = Math.min(truckSize, count[i]);
            ans += spent * i;
            truckSize -= spent;
        }
        return ans;
    }
}
