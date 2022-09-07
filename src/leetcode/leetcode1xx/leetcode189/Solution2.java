package leetcode.leetcode1xx.leetcode189;

public class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2 || k % n == 0) return;
        k %= n;
        int gcd = gcd(k, n);
        for (int start = 0; start < gcd; start++) {
            int tmp = nums[start];
            int to = start, from = start - k + n;
            while (from != start) {
                nums[to] = nums[from];
                to = from;
                from -= k;
                if (from < 0) from += n;
            }
            nums[to] = tmp;
        }

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
