package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalList {
    private final int[][] a;

    public IntervalList(int[][] a) {
        this.a = a;
    }

    public IntervalList union(IntervalList other) {
        int[][] b = other.a;
        int m = this.a.length;
        int n = b.length;
        if (m == 0) return other;
        if (n == 0) return this;
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>(this.a.length + b.length);
        while (i < m || j < n) {
            int curMin = Integer.MAX_VALUE;
            if (i < m) curMin = Math.min(curMin, a[i][0]);
            if (j < n) curMin = Math.min(curMin, b[j][0]);
            int curMax = curMin;
            boolean found = true;
            while (found) {
                found = false;
                while (i < m && this.a[i][0] <= curMax) {
                    found = true;
                    curMax = Math.max(curMax, a[i][1]);
                    i++;
                }
                while (j < n && b[j][0] <= curMax) {
                    found = true;
                    curMax = Math.max(curMax, b[j][1]);
                    j++;
                }
            }
            ans.add(new int[]{curMin, curMax});
        }
        return new IntervalList(ans.toArray(new int[ans.size()][2]));
    }

    public IntervalList intersect(IntervalList other) {
        int[][] b = other.a;
        int m = this.a.length;
        int n = b.length;
        if (m == 0 || n == 0) return new IntervalList(new int[0][2]);
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>(Math.max(m, n) + 1);
        while (i < m && j < n) {
            while (i < m && j < n && (this.a[i][0] > b[j][1] || b[j][0] > this.a[i][1])) {
                while (i < m && this.a[i][1] < b[j][0]) i++;
                if (i == m) break;
                while (j < n && b[j][1] < this.a[i][0]) j++;
                if (j == n) break;
            }
            if (i == m || j == n) break;
            ans.add(new int[]{Math.max(this.a[i][0], b[j][0]), Math.min(this.a[i][1], b[j][1])});
            if (this.a[i][1] >= b[j][1]) j++;
            else i++;
        }

        return new IntervalList(ans.toArray(new int[ans.size()][2]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalList that = (IntervalList) o;
        return Arrays.deepEquals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(a);
    }

}
