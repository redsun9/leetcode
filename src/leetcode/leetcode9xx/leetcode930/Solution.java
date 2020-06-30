package leetcode.leetcode9xx.leetcode930;

public class Solution {
    public int numSubarraysWithSum(int[] a, int s) {
        int psum = 0;
        int res = 0;
        int[] count = new int[a.length + 1];
        count[0] = 1;
        for (int i : a) {
            psum += i;
            if (psum >= s)
                res += count[psum - s];
            count[psum]++;
        }
        return res;
    }
}
