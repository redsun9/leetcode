package help_requests.beautiful_alley;

// a = maximum consecutive 0
// b = maximum consecutive 1
// beauty = a+b
// you can flip up to 1 number

public class Solution {
    public static int maxBeauty(String s) {
        int n = s.length();
        if (n <= 3) return n;
        int[] leftZero0 = helper(s, '0', 0, 0, n, 1);
        int[] leftZero1 = helper(s, '0', 1, 0, n, 1);
        int[] rightZero0 = helper(s, '0', 0, n - 1, -1, -1);
        int[] rightZero1 = helper(s, '0', 1, n - 1, -1, -1);

        int[] leftOne0 = helper(s, '1', 0, 0, n, 1);
        int[] leftOne1 = helper(s, '1', 1, 0, n, 1);
        int[] rightOne0 = helper(s, '1', 0, n - 1, -1, -1);
        int[] rightOne1 = helper(s, '1', 1, n - 1, -1, -1);

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, leftZero0[i] + rightOne1[i + 1]);
            ans = Math.max(ans, leftZero1[i] + rightOne0[i + 1]);
            ans = Math.max(ans, leftOne0[i] + rightZero1[i + 1]);
            ans = Math.max(ans, leftOne1[i] + rightZero0[i + 1]);
        }
        return ans;
    }

    private static int[] helper(String s, char c, int k, int start, int end, int di) {
        int[] ans = new int[s.length() + 2];
        for (int i1 = start, i2 = start, count = 0, max = 0; i1 != end; i1 += di) {
            if (s.charAt(i1) != c) count++;
            while (count > k) {
                if (s.charAt(i2) != c) count--;
                i2 += di;
            }
            max = Math.max(max, (i1 - i2) * di + 1);
            ans[i1 + 1] = max;
        }
        return ans;
    }
}
