package leetcode.leetcode20xx.leetcode2040;

import java.util.Arrays;

@SuppressWarnings({"DuplicatedCode"})
public class Solution3 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        int nNeg1 = numberOfNegative(nums1), nPos1 = numberOfPositive(nums1), nZero1 = n1 - nNeg1 - nPos1;
        int nNeg2 = numberOfNegative(nums2), nPos2 = numberOfPositive(nums2), nZero2 = n2 - nNeg2 - nPos2;

        long totalNeg = (long) nNeg1 * nPos2 + (long) nNeg2 * nPos1;
        if (totalNeg >= k) {
            int[] pos1 = Arrays.copyOfRange(nums1, n1 - nPos1, n1);
            int[] pos2 = Arrays.copyOfRange(nums2, n2 - nPos2, n2);
            int[] neg1 = Arrays.copyOfRange(nums1, 0, nNeg1);
            int[] neg2 = Arrays.copyOfRange(nums2, 0, nNeg2);
            mirror(pos1);
            mirror(pos2);
            return kthSmallestPositiveProduct(pos1, neg2, pos2, neg1, k);
        }

        k -= totalNeg;
        long totalZero = (long) nZero1 * n2 + (long) nZero2 * n1 - (long) nZero1 * nZero2;

        if (totalZero >= k) return 0L;
        else {
            k -= totalZero;
            int[] pos1 = Arrays.copyOfRange(nums1, n1 - nPos1, n1);
            int[] pos2 = Arrays.copyOfRange(nums2, n2 - nPos2, n2);
            int[] neg1 = Arrays.copyOfRange(nums1, 0, nNeg1);
            int[] neg2 = Arrays.copyOfRange(nums2, 0, nNeg2);
            mirror(neg1);
            mirror(neg2);
            return kthSmallestPositiveProduct(pos1, pos2, neg1, neg2, k);
        }
    }

    private static void mirror(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    private static long kthSmallestPositiveProduct(int[] pos1, int[] pos2, int[] neg1, int[] neg2, long k) {
        int nPos1 = pos1.length, nPos2 = pos2.length, nNeg1 = neg1.length, nNeg2 = neg2.length;

        long lo = Long.MAX_VALUE, hi = Long.MIN_VALUE;
        if (nPos1 != 0 && nPos2 != 0) {
            lo = Math.min(lo, (long) pos1[0] * pos2[0]);
            hi = Math.max(hi, (long) pos1[nPos1 - 1] * pos2[nPos2 - 1]);
        }
        if (nNeg1 != 0 && nNeg2 != 0) {
            lo = Math.min(lo, (long) neg1[0] * neg2[0]);
            hi = Math.max(hi, (long) neg1[nNeg1 - 1] * neg2[nNeg2 - 1]);
        }

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = check(pos1, pos2, mid) + check(neg1, neg2, mid);
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static long check(int[] a, int[] b, long mid) {
        long count = 0;
        int j = b.length - 1;

        for (long aVal : a) {
            while (j >= 0 && aVal * b[j] > mid) j--;
            count += j + 1;
        }

        return count;
    }


    private static int numberOfNegative(int[] arr) {
        int lo = -1, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (arr[mid] >= 0) hi = mid - 1;
            else lo = mid;
        }
        return lo + 1;
    }

    private static int numberOfPositive(int[] arr) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= 0) lo = mid + 1;
            else hi = mid;
        }
        return arr.length - lo;
    }
}
