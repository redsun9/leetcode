package leetcode.leetcode21xx.leetcode2176;

public class Solution2 {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[0] == nums[i]) ans++;
            int left = k / gcd(i, k);
            for (int j = (i / left + 1) * left; j < n; j += left) {
                if (nums[i] == nums[j]) ans++;
            }
        }
        return ans;
    }

    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}