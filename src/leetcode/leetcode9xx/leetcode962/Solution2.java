package leetcode.leetcode9xx.leetcode962;

import java.util.Stack;

public class Solution2 {
    public int maxWidthRamp(int[] a) {
        int n = a.length;
        if (n < 2) return n;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; ++i)
            if (s.empty() || a[s.peek()] > a[i])
                s.add(i);
        for (int i = n - 1; i > ans; --i)
            while (!s.empty() && a[s.peek()] <= a[i])
                ans = Math.max(ans, i - s.pop());
        return ans;
    }
}
