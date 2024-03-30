package leetcode.leetcode30xx.leetcode3005;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) count[num]++;
        int maxFreq = 0;
        for (int j : count) maxFreq = Math.max(maxFreq, j);
        int countWithFreq = 0;
        for (int j : count) if (j == maxFreq) countWithFreq++;
        return countWithFreq * maxFreq;
    }
}
