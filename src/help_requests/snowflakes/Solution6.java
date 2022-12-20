package help_requests.snowflakes;

import java.util.HashSet;
import java.util.Set;

// canonize snowflake by getting minimum array
// O(n) - space, cause of reusing arrays
// O(n*k*k) - average time, O(n*n*k + n*k*k) - worst
public class Solution6 {
    public static boolean allUnique(int[][] snowflakes) {
        int n = snowflakes.length;
        Set<ArrayWrapper> set = new HashSet<>();
        for (int[] snowflake : snowflakes) if (!set.add(canonize(snowflake))) return false;
        return true;
    }

    private static ArrayWrapper canonize(int[] arr) {
        int n = arr.length;
        int minShift = 0, minDirection = 1;

        for (int shift = 0; shift < n; shift++) {
            for (int direction = -1; direction <= 1; direction += 2) {
                if (isLess(arr, minShift, minDirection, shift, direction)) {
                    minShift = shift;
                    minDirection = direction;
                }
            }
        }
        return new ArrayWrapper(arr, minShift, minDirection);
    }

    private static boolean isLess(int[] arr, int s1, int d1, int s2, int d2) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[s1] != arr[s2]) return arr[s1] > arr[s2];

            s1 += d1;
            if (s1 == n) s1 = 0;
            else if (s1 < 0) s1 = n - 1;

            s2 += d2;
            if (s2 == n) s2 = 0;
            else if (s2 < 0) s2 = n - 1;
        }

        return false;
    }


    private static class ArrayWrapper {
        final int[] arr;
        final int shift, direction;

        private ArrayWrapper(int[] arr, int shift, int direction) {
            this.arr = arr;
            this.shift = shift;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayWrapper that = (ArrayWrapper) o;
            int n = arr.length;
            for (int i = 0, j1 = this.shift, j2 = that.shift; i < n; i++) {
                if (this.arr[j1] != that.arr[j2]) return false;

                j1 += this.direction;
                if (j1 == n) j1 = 0;
                else if (j1 < 0) j1 = n - 1;

                j2 += that.direction;
                if (j2 == n) j2 = 0;
                else if (j2 < 0) j2 = n - 1;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;
            int n = arr.length;

            for (int i = 0, j = shift; i < n; i++) {
                result = 31 * result + arr[j];
                j += direction;
                if (j == n) j = 0;
                else if (j < 0) j = n - 1;
            }
            return result;
        }
    }
}
