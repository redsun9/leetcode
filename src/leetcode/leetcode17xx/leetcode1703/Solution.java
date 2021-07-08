package leetcode.leetcode17xx.leetcode1703;

// sliding window
// memory usage - O(k)

public class Solution {
    private static int closest(int[] nums) {
        int n = nums.length;
        int l = -n, ans = n;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ans = Math.min(ans, i - l);
                l = i;
            }
        }
        return ans - 1;
    }

    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return 0;
        if (k == 2) return closest(nums);

        int[] q = new int[k];
        int counter = 0, i = 0;
        while (counter < k) {
            if (nums[i] == 1) q[counter++] = i;
            i++;
        }

        int l = 0, r = (k + 1) / 2;
        int curr = 0;
        for (int j = r; j < k; j++) curr += q[j];
        for (int j = 0; j < r; j++) curr -= q[j];

        int ans;
        if (k % 2 == 0) {
            ans = curr;
            while (i < n) {
                if (nums[i] == 1) {
                    curr += i + q[l] - 2 * q[r];
                    q[l] = i;
                    if (++l == k) l = 0;
                    if (++r == k) r = 0;
                    ans = Math.min(ans, curr);
                }
                i++;
            }
        } else {
            int m = r - 1;
            curr = curr + q[m];
            ans = curr;
            while (i < n) {
                if (nums[i] == 1) {
                    curr += i + q[l] - q[r] - q[m];
                    q[l] = i;
                    if (++l == k) l = 0;
                    m = r;
                    if (++r == k) r = 0;
                    ans = Math.min(ans, curr);
                }
                i++;
            }
        }
        int t = k / 2;
        return ans - (k % 2 == 0 ? t * t : t * (t + 1));
    }
}
