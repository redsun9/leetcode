package leetcode.leetcode8xx.leetcode849;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int ans = 1;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                ans = last == -1 ? i : Math.max(ans, (i - last) / 2);
                last = i;
            }
        }
        ans = Math.max(ans, (n - 1 - last));
        return ans;
    }
}
