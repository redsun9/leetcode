package leetcode.leetcode9xx.leetcode977;

/*
    Inplace solution, O(m*n) - worst case (then all negative absolute values are higher than all positive)
 */
public class Solution {
    private static void square(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) a[i] *= a[i];
    }

    private static void mirror(int[] a, int i, int j) {
        if (i >= j) return;
        int tmp;
        while (i < j) {
            tmp = a[i];
            a[i++] = a[j];
            a[j--] = tmp;
        }
    }

    public int[] sortedSquares(int[] a) {
        int n = a.length;
        if (n == 0) return a;
        if (a[0] < 0) {
            if (a[n - 1] >= 0) {
                int lo = 0, hi = n - 1;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (a[mid] >= 0) hi = mid;
                    else lo = mid + 1;
                }
                //hi -first non negative
                square(a);
                int leftEnd = hi - 1;
                mirror(a, 0, leftEnd);
                for (int j = n - 1; j >= hi; j--) {
                    int jVal = a[j];
                    if (jVal >= a[leftEnd]) continue;
                    int i, last = a[leftEnd];
                    for (i = leftEnd; i > 0 && a[i - 1] > a[j]; i--) a[i] = a[i - 1];
                    a[i] = a[j];
                    a[j] = last;
                }
            } else {
                //only negative values
                square(a);
                mirror(a, 0, n - 1);
            }
        } else {
            //no negative values
            square(a);
        }
        return a;
    }
}
