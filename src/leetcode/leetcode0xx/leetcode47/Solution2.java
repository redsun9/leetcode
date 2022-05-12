package leetcode.leetcode0xx.leetcode47;

import java.util.AbstractList;
import java.util.List;

public class Solution2 {
    private static final int MIN_VAL = -10;
    private static final int MAX_VAL = 10;
    private static final int M = MAX_VAL - MIN_VAL + 1;

    public List<List<Integer>> permuteUnique(int[] nums) {
        return new MyListList(nums);
    }

    private static class MyListList extends AbstractList<List<Integer>> {
        private final int[] map;
        private final int[] weights;
        private final int[][] dp;
        private final int n;

        MyListList(int[] nums) {
            this.map = new int[M];
            for (int num : nums) map[num - MIN_VAL]++;
            this.n = nums.length;
            this.weights = new int[M + 1];
            int count = 0, max = 0;
            for (int val : map) max = Math.max(max, val);

            this.dp = new int[n + 1][max + 1];
            for (int i = 0; i <= n; i++) dp[i][0] = 1;
            for (int j = 0; j <= max; j++) dp[j][j] = 1;
            for (int i = 1; i <= n; i++) for (int j = 1; j <= max; j++) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];

            this.weights[0] = 1;
            for (int i = 0, prefSum = 0; i < M; i++) {
                weights[i + 1] = weights[i] * dp[prefSum + map[i]][map[i]];
                prefSum += map[i];
            }
        }

        @Override
        public List<Integer> get(int index) {
            int[] nums = new int[n];
            int used = 0;
            for (int i = M - 1, left = n; i >= 0; i--) {
                if (map[i] == 0) continue;
                int val = map[i];
                int subIndex = index / weights[i] + 1;
                index %= weights[i];
                for (int j = 0, rightLeft = left; j < n && val != 0; j++) {
                    if ((used >> j & 1) == 1) continue;
                    if (subIndex <= dp[rightLeft - 1][val - 1]) {
                        used |= 1 << j;
                        nums[j] = i + MIN_VAL;
                        val--;
                    } else subIndex -= dp[rightLeft - 1][val - 1];
                    rightLeft--;
                }
                left -= map[i];
            }
            return new MyList(nums);
        }

        @Override
        public int size() {
            return weights[M];
        }
    }

    private static class MyList extends AbstractList<Integer> {
        private final int[] nums;

        MyList(int[] nums) {
            this.nums = nums;
        }

        @Override
        public Integer get(int index) {
            return nums[index];
        }

        @Override
        public int size() {
            return nums.length;
        }
    }
}
