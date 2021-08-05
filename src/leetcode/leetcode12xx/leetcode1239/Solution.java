package leetcode.leetcode12xx.leetcode1239;

import java.util.List;

// Space - O(n), time - O(n*2^n)

public class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[] masks = new int[n];
        int mask, len;
        String s;
        for (int i = 0; i < n; i++) {
            mask = 0;
            s = arr.get(i);
            len = s.length();
            for (int j = 0; j < len; j++) mask |= 1 << s.charAt(j) - 'a';
            if (Integer.bitCount(mask) != len) mask = 0;
            masks[i] = mask;
        }
        int ans = 0;
        for (int selected = (1 << n) - 1; selected != 0; selected--) {
            mask = 0;
            for (int i = 0; i < n; i++) {
                if ((selected >> i & 1) == 1) {
                    if ((mask & masks[i]) == 0) mask |= masks[i];
                    else {
                        mask = 0;
                        break;
                    }
                }
            }
            ans = Math.max(ans, Integer.bitCount(mask));
        }
        return ans;
    }
}
