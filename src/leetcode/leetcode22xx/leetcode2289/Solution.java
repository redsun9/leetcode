package leetcode.leetcode22xx.leetcode2289;

// O(n^2) - time
// O(n) - space
// Only to test another solutions
public class Solution {
    public int totalSteps(int[] nums) {
        int ans = 0;
        int[] prev = nums, next;
        int prevLen = nums.length;
        while (true) {
            if (prevLen <= 1) break;
            next = new int[prevLen];
            next[0] = prev[0];
            int curLen = 1;
            for (int i = 1; i < prevLen; i++) if (prev[i] >= prev[i - 1]) next[curLen++] = prev[i];
            if (curLen == prevLen) break;
            prev = next;
            prevLen = curLen;
            ans++;
        }
        return ans;
    }
}
