package leetcode.leetcode0xx.leetcode90;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return new MyListList(nums);
    }

    private static class MyListList extends AbstractList<List<Integer>> {
        private final int[] nums, weights;
        private final int n;


        MyListList(int[] arr) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : arr) count.compute(num, (k, v) -> v == null ? 1 : v + 1);

            this.n = count.size();
            this.nums = new int[n];
            this.weights = new int[n + 1];
            weights[0] = 1;
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                nums[i] = entry.getKey();
                weights[i + 1] = weights[i] * (entry.getValue() + 1);
                i++;
            }
        }

        @Override
        public AbstractList<Integer> get(int index) {
            return new MyListList.MyList(index);
        }

        @Override
        public int size() {
            return weights[n];
        }

        private class MyList extends AbstractList<Integer> {
            private final int[] digits = new int[n + 1];

            MyList(int mask) {
                for (int i = 0; i < n; i++) digits[i + 1] = digits[i] + mask % weights[i + 1] / weights[i];
            }

            @Override
            public Integer get(int index) {
                int lo = 0, hi = n;
                while (lo < hi) {
                    int mid = (lo + hi + 1) / 2;
                    if (digits[mid] > index) hi = mid - 1;
                    else lo = mid;
                }
                return nums[lo];
            }

            @Override
            public int size() {
                return digits[n];
            }
        }
    }
}
