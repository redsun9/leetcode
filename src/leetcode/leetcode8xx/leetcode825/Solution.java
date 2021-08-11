package leetcode.leetcode8xx.leetcode825;

public class Solution {
    private static final int MAX_AGE = 120;

    public int numFriendRequests(int[] ages) {
        int[] count = new int[MAX_AGE + 1];
        for (int age : ages) count[age]++;
        int ans = 0;
        for (int x = 1; x <= MAX_AGE; x++) {
            for (int y = 1; y <= x; y++) {
                if (2 * y - 14 > x) {
                    if (x == y) ans += count[x] * (count[x] - 1);
                    else ans += count[x] * count[y];
                }
            }
        }
        return ans;
    }
}
