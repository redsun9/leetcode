package help_requests.find_subsequence;

// O(N*logM), N - size of needle, M - size of haystack
@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public static int[] findSubsequence(int[] haystack, int[] needle) {
        int m = haystack.length, n = needle.length;
        if (m < n) return null;

        int[] ans = new int[n];

        int i = 0, j = 0;
        while (i < n && j < m) {
            j = binarySearchMostLeft(haystack, j, m, needle[i]);
            if (j < 0) return null;
            ans[i++] = j;
            j++;
        }
        if (i == n) return ans;
        else return null;
    }

    private static int binarySearchMostLeft(int[] a, int fromIndex, int toIndex, int key) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        if (fromIndex < 0) throw new ArrayIndexOutOfBoundsException(fromIndex);
        if (toIndex > a.length) throw new ArrayIndexOutOfBoundsException(toIndex);

        int low = fromIndex - 1;
        int high = toIndex - 1;

        while (low < high) {
            int mid = (low + high + 1) >>> 1;
            if (a[mid] < key) low = mid;
            else high = mid - 1;
        }
        low++;
        if (low == toIndex || a[low] != key) return -1;
        return low;
    }
}
