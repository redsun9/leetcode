package leetcode.leetcode9xx.leetcode961;

//deterministic
public class Solution {
    public int repeatedNTimes(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) return a[i];
        }
        if (a[0] == a[2]) return a[0];
        if (a[0] == a[3]) return a[0];
        return a[1];
    }
}
