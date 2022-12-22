package help_requests.find_subsequence;

@SuppressWarnings("DuplicatedCode")
public class Solution3 {
    public static int[] findSubsequence(int[] haystack, int[] needle) {
        int m = haystack.length, n = needle.length;
        if (m < n) return null;

        int[] ans = new int[n];
        int i = 0, j = 0;
        while (i < n && j < m) {
            j = interpolationSearchMostLeft(haystack, j, m, needle[i]);
            if (j < 0) return null;
            ans[i++] = j;
            j++;
        }
        if (i == n) return ans;
        else return null;
    }

    private static int interpolationSearchMostLeft(int[] a, int fromIndex, int toIndex, int key) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        if (fromIndex < 0) throw new ArrayIndexOutOfBoundsException(fromIndex);
        if (toIndex > a.length) throw new ArrayIndexOutOfBoundsException(toIndex);

        int low = fromIndex - 1;
        int high = toIndex - 1;

        while (low < high) {
            if (a[high] < key || a[low + 1] >= key) break;
            int mid = low + (key - a[low + 1]) * (high - low + 1) / (a[high] - a[low + 1] + 1);
            if (mid == low) mid++;
            int midVal = a[mid];
            if (midVal < key) low = mid;
            else high = mid - 1;
        }
        low++;
        if (a[low] == key) return low;
        if (high + 1 == toIndex || a[high + 1] != key) return -1;
        return high + 1;
    }
}
