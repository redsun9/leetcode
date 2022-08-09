package leetcode.leetcode23xx.leetcode2369;

public class Solution {
    public boolean validPartition(int[] a) {
        int n = a.length;
        boolean p3 = true, p2 = false, p1 = a[0] == a[1], curr;
        for (int i = 2; i < n; i++) {
            curr = p2 && a[i] == a[i - 1] ||
                    p3 && a[i] == a[i - 1] && a[i] == a[i - 2] ||
                    p3 && a[i] == a[i - 1] + 1 && a[i] == a[i - 2] + 2;
            p3 = p2;
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
}
