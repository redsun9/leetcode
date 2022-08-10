package help_requests.all_possible_combinations;

import java.util.AbstractList;
import java.util.List;

public class Solution {
    public static List<int[]> getAllPossibleCombinations(int[][] ranges) {
        return new MyList(ranges);
    }

    private static class MyList extends AbstractList<int[]> {
        private final int[][] ranges;
        private final int n;

        MyList(int[][] ranges) {
            this.ranges = ranges;
            this.n = ranges.length;
        }

        @Override
        public int[] get(int index) {
            int[] arr = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                int m = ranges[i][1] - ranges[i][0] + 1;
                arr[i] = ranges[i][0] + index % m;
                index /= m;
            }
            return arr;
        }

        @Override
        public int size() {
            int size = 1;
            for (int[] range : ranges) size *= range[1] - range[0] + 1;
            return size;
        }
    }
}
