package leetcode.leetcode23xx.leetcode2375;

public class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] ans = new char[n + 1];
        for (int i = 0; i <= n; i++) ans[i] = (char) ('1' + i);
        for (int l = 0; l < n; ) {
            if (pattern.charAt(l) == 'D') {
                int r = l + 1;
                while (r < n && pattern.charAt(r) == 'D') r++;
                mirror(ans, l, r);
                l = r + 1;
            } else {
                l++;
            }
        }
        return new String(ans);
    }

    private static void mirror(char[] arr, int l, int r) {
        while (l < r) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
            l++;
            r--;
        }
    }
}
