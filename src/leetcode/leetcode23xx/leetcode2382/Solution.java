package leetcode.leetcode23xx.leetcode2382;

public class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        // l = 0 || r==0 => пустой
        long[] ans = new long[n], s = new long[n];
        int[] l = new int[n], r = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int pos = removeQueries[i + 1], curLeft = 1, curRight = 1;
            long curS = nums[pos];
            if (pos != 0 && l[pos - 1] != 0) {
                curS += s[pos - 1];
                curLeft += l[pos - 1];
            }
            if (pos != n - 1 && r[pos + 1] != 0) {
                curS += s[pos + 1];
                curRight += r[pos + 1];
            }
            int lb = pos - curLeft + 1, rb = pos + curRight - 1, len = rb - lb + 1;
            r[lb] = len;
            l[rb] = len;
            s[lb] = curS;
            s[rb] = curS;
            ans[i] = Math.max(ans[i + 1], curS);
        }
        return ans;
    }
}
