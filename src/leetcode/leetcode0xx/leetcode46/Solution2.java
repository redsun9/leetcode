package leetcode.leetcode0xx.leetcode46;

import java.util.AbstractList;
import java.util.List;

public class Solution2 {
    public static List<List<Integer>> permute(int[] nums) {
        return new MyListList(nums);
    }

    private static class MyListList extends AbstractList<List<Integer>> {
        private final int[] nums, weights;
        private final int n;

        MyListList(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.weights = new int[n + 1];
            weights[n] = 1;
            for (int i = n - 1, k = 1; i >= 0; i--, k++) weights[i] = weights[i + 1] * k;
        }

        @Override
        public List<Integer> get(int index) {
            return new MyList(index);
        }

        @Override
        public int size() {
            return weights[0];
        }


        private class MyList extends AbstractList<Integer> {
            private final int[] arr = new int[n];

            MyList(int mask) {
                int available = (1 << n) - 1;
                for (int i = 0; i < n; i++) {
                    int index = mask % weights[i] / weights[i + 1];

                    //find pos of index-th lowest set bit
                    int j = 0;
                    while (index > 0 || (available >>> j & 1) == 0) if ((available >>> j++ & 1) == 1) index--;
                    arr[i] = nums[j];
                    available ^= 1 << j;
                }
            }

            @Override
            public Integer get(int index) {
                return arr[index];
            }

            @Override
            public int size() {
                return n;
            }
        }
    }
}
