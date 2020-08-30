package leetcode.leetcode15xx.leetcode1566;

public class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int len = m * k;
        if (n < len) return false;
        if (k == 1) return true;
        for (int i1 = 0, i2 = m, i3 = 0; i2 < n; i2++, i3++) {
            if (arr[i2] == arr[i3]) {
                if (i2 - i1 == len - 1) return true;
            } else {
                i1 = i3 + 1;
            }
        }
        return false;
    }
}
