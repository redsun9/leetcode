package leetcode.leetcode3xx.leetcode302;

// Time complexity - O(NlogM + MlogN)

@SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;

        int left = y, right = y, top = x, bottom = x, lo, hi;

        //find left
        lo = 0;
        hi = left;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean found = false;
            for (int i = 0; i < m; i++) {
                if (image[i][mid] == '1') {
                    found = true;
                    top = Math.max(top, i);
                    bottom = Math.min(bottom, i);
                    break;
                }
            }
            if (found) hi = mid;
            else lo = mid + 1;
        }
        left = lo;

        //find right
        lo = right;
        hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            boolean found = false;
            for (int i = 0; i < m; i++) {
                if (image[i][mid] == '1') {
                    found = true;
                    top = Math.max(top, i);
                    bottom = Math.min(bottom, i);
                    break;
                }
            }
            if (found) lo = mid;
            else hi = mid - 1;
        }
        right = lo;

        //find top
        lo = top;
        hi = m - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            char[] arr = image[mid];
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    found = true;
                    break;
                }
            }
            if (found) lo = mid;
            else hi = mid - 1;
        }
        top = lo;

        //find bottom
        lo = 0;
        hi = bottom;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            char[] arr = image[mid];
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    found = true;
                    break;
                }
            }
            if (found) hi = mid;
            else lo = mid + 1;
        }
        bottom = lo;


        return (right - left + 1) * (top - bottom + 1);

    }
}
