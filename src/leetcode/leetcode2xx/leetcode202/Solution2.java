package leetcode.leetcode2xx.leetcode202;

public class Solution2 {
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = sum(sum(fast));
            slow = sum(slow);
        } while (fast != 1 && fast != slow);
        return fast == 1;
    }

    private static int sum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }
        return ans;
    }
}
