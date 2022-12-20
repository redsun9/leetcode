package help_requests.snowflakes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// canonize snowflake by getting minimum array
// O(n*k) - space
// O(n*k*k) - average time, O(n*n*k + n*k*k) - worst
public class Solution4 {
    public static boolean allUnique(int[][] snowflakes) {
        int n = snowflakes.length;
        Set<ArrayWrapper> set = new HashSet<>();
        for (int[] snowflake : snowflakes) if (!set.add(new ArrayWrapper(canonize(snowflake)))) return false;

        return true;
    }

    private static int[] canonize(int[] arr) {
        int n = arr.length;
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int shift = 0; shift < n; shift++) {
            for (int direction = -1; direction <= 1; direction += 2) {
                if (isLess(min, arr, shift, direction)) copyArray(min, arr, shift, direction);
            }
        }
        return min;
    }

    private static boolean isLess(int[] prev, int[] arr, int shift, int direction) {
        int n = arr.length;
        for (int i = 0, j = shift; i < n; i++) {
            if (arr[j] != prev[i]) return arr[j] < prev[i];
            j += direction;
            if (j < 0) j = n - 1;
            else if (j == n) j = 0;
        }
        return false;
    }

    private static void copyArray(int[] prev, int[] arr, int shift, int direction) {
        int n = arr.length;
        for (int i = 0, j = shift; i < n; i++) {
            prev[i] = arr[j];
            j += direction;
            if (j < 0) j = n - 1;
            else if (j == n) j = 0;
        }
    }

    private static class ArrayWrapper {
        final int[] arr;

        private ArrayWrapper(int[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayWrapper that = (ArrayWrapper) o;
            return Arrays.equals(arr, that.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }
}
