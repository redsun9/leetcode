package leetcode.leetcode20xx.leetcode2086;

public class Solution {
    public int minimumBuckets(String street) {
        int ans = 0, n = street.length(), i = 0;
        while (i < n) {
            if (street.charAt(i) == 'H') {
                if (i + 1 < n && street.charAt(i + 1) == '.') {
                    i += 3;
                } else if (i != 0 && street.charAt(i - 1) == '.') {
                    i++;
                } else return -1;
                ans++;
            } else i++;
        }
        return ans;
    }
}
