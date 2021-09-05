package leetcode.leetcode0xx.leetcode78;

import java.util.AbstractList;
import java.util.List;

// Use lazy initialization

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        return new MyListList(nums);
    }

    private static class MyListList extends AbstractList<List<Integer>> {
        private final int[] nums;
        private final int n;

        MyListList(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
        }

        @Override
        public AbstractList<Integer> get(int index) {
            return new MyList(index);
        }

        @Override
        public int size() {
            return 1 << n;
        }

        private class MyList extends AbstractList<Integer> {
            private final int mask;

            MyList(int mask) {
                this.mask = mask;
            }

            @Override
            public Integer get(int index) {
                int i = 0;

                //find pos of i-th lowest set bit
                while (index > 0 || (mask >>> i & 1) == 0) if ((mask >>> i++ & 1) == 1) index--;
                return nums[i];
            }

            @Override
            public int size() {
                return Integer.bitCount(mask);
            }
        }
    }
}
