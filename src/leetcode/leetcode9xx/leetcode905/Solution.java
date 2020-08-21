package leetcode.leetcode9xx.leetcode905;

public class Solution {
    public int[] sortArrayByParity(int[] a) {
        int n = a.length;
        int i = 0, pos = 0;
        while (i < n) {
            if ((a[i] & 1) == 0) {
                int tmp = a[i];
                a[i] = a[pos];
                a[pos++] = tmp;
            }
            i++;
        }
        return a;
    }
}
