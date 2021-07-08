package leetcode.leetcode17xx.leetcode1703;

// sliding window
// memory usage - O(1)

public class Solution2 {
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

        int counter = 0, i = 0;
        int ql, qm, qr;
        int m = (k - 1) / 2;
        int curr = 0;

        while (nums[i] != 1) i++;
        ql = i++;
        curr -= ql;
        counter++;

        while (counter <= m) {
            if (nums[i] == 1) {
                curr -= i;
                counter++;
            }
            i++;
        }
        qm = i - 1;

        while (nums[i] != 1) i++;
        qr = i++;
        curr += qr;
        counter++;

        while (counter < k) {
            if (nums[i] == 1) {
                curr += i;
                counter++;
            }
            i++;
        }

        int ans;
        if (k % 2 == 0) {
            ans = curr;
            while (i < n) {
                if (nums[i] == 1) {
                    curr += i + ql - 2 * qr;
                    ql++;
                    while (nums[ql] == 0) ql++;
                    qr++;
                    while (nums[qr] == 0) qr++;
                    ans = Math.min(ans, curr);
                }
                i++;
            }
        } else {
            curr += qm;
            ans = curr;
            while (i < n) {
                if (nums[i] == 1) {
                    curr += i + ql - qr - qm;
                    ql++;
                    while (nums[ql] == 0) ql++;
                    qr++;
                    while (nums[qr] == 0) qr++;
                    qm++;
                    while (nums[qm] == 0) qm++;
                    ans = Math.min(ans, curr);
                }
                i++;
            }
        }
        int t = k / 2;
        return ans - (k % 2 == 0 ? t * t : t * (t + 1));
    }
}
