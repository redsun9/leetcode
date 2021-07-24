package leetcode.leetcode4xx.leetcode457;

public class Solution {
    private static int getPos(int i, int diff, int n) {
        i += diff;
        i %= n;
        if (i < 0) i += n;
        return i;
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (val == 0) continue;
            int slow = i;
            int slowNext = getPos(i, val, n);
            int fast = slowNext;
            int fastNext = getPos(fast, nums[fast], n);
            while (nums[fast] * val > 0 && nums[fastNext] * val > 0) {
                if (fast == slow) {
                    if (slow == slowNext) break;
                    return true;
                }
                slow = slowNext;
                slowNext = getPos(slow, nums[slow], n);
                fast = getPos(fastNext, nums[fastNext], n);
                fastNext = getPos(fast, nums[fast], n);
            }
            slow = i;
            while (nums[slow] * val > 0) {
                slowNext = getPos(slow, nums[slow], n);
                nums[slow] = 0;
                slow = slowNext;
            }
        }
        return false;
    }
}
