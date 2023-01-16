package help_requests.number_of_good_pairs;

import java.util.Arrays;
import java.util.Comparator;

// given two permutations of length n. find out how many good pairs of (i,j).
// (i,j) is a good pair if i<j && (x[i]<x[j] && y[i]<y[j] || x[i]>x[j] && y[i]>y[j])
public class Solution {
    public static long numberOfGoodPairs(int[] x, int[] y) {
        int n = x.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = x[i];
            pairs[i][1] = y[i];
        }
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) tmp[i] = pairs[i][1];
        return n * (n - 1L) / 2 - sortAndCountBad(tmp, 0, n);
    }

    private static long sortAndCountBad(int[] arr, int start, int end) {
        int len = end - start;
        if (len <= 1) return 0;
        int mid = (start + end) >>> 1;
        long ans = sortAndCountBad(arr, start, mid) + sortAndCountBad(arr, mid, end);
        ans += mergeAndCountBad(arr, start, mid, end);
        return ans;
    }

    private static long mergeAndCountBad(int[] arr, int start, int mid, int end) {
        int len = end - start;
        int[] tmp = new int[len];
        long ans = 0;
        int i = 0, i1 = start, i2 = mid;
        while (i < len) {
            if (i2 == end || i1 < mid && arr[i1] < arr[i2]) tmp[i++] = arr[i1++];
            else {
                ans += mid - i1;
                tmp[i++] = arr[i2++];
            }
        }
        i = 0;
        i1 = start;
        while (i < len) arr[i1++] = tmp[i++];
        return ans;
    }
}
