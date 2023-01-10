package help_requests.snowflakes;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
public class Solution7 {
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
                if (isLess(arr, shift, direction, minShift, minDirection)) {
                    minShift = shift;
                    minDirection = direction;
                }
            }
        }
        return new ArrayWrapper(arr, minShift, minDirection);
    }

    private static boolean isLess(int[] arr, int shift1, int direction1, int shift2, int direction2) {
        int n = arr.length;
        for (int i = 0, j1 = shift1, j2 = shift2; i < n; i++) {
            if (arr[j1] != arr[j2]) return arr[j1] < arr[j2];
            j1 = next(j1, direction1, n);
            j2 = next(j2, direction2, n);
        }
        return false;
    }

    private static boolean isEqual(int[] arr, int shift1, int direction1, int[] arr2, int shift2, int direction2) {
        int n = arr.length;
        for (int i = 0, j1 = shift1, j2 = shift2; i < n; i++) {
            if (arr[j1] != arr2[j2]) return false;
            j1 = next(j1, direction1, n);
            j2 = next(j2, direction2, n);
        }
        return true;
    }

    private record ArrayWrapper(int[] arr, int shift, int direction) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayWrapper that = (ArrayWrapper) o;
            return isEqual(this.arr, this.shift, this.direction, that.arr, that.shift, that.direction);
        }

        @Override
        public int hashCode() {
            int result = 1, n = this.arr.length;
            for (int i = 0, j = this.shift; i < n; i++) {
                result = 31 * result + arr[j];
                j = next(j, direction, n);
            }
            return result;
        }
    }

    private static int next(int i, int direction, int n) {
        i += direction;
        if (i < 0) i = n - 1;
        else if (i == n) i = 0;
        return i;
    }
}
