package help_requests.find_subsequence;

// O(m+n) - time
// doesn't use that arrays are sorted
public class Solution {
    public static int[] findSubsequence(int[] haystack, int[] needle) {
        int m = haystack.length, n = needle.length;
        if (m < n) return null;

        int[] ans = new int[n];

        int i = 0;
        for (int j = 0; j < m && i < n; j++) if (haystack[j] == needle[i]) ans[i++] = j;

        if (i == n) return ans;
        else return null;
    }
}
