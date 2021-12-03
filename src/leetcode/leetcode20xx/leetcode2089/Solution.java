package leetcode.leetcode20xx.leetcode2089;

import java.util.AbstractList;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countLess = 0, countEqual = 0;
        for (int num : nums) {
            if (num < target) countLess++;
            else if (num == target) countEqual++;
        }
        return new MyList(countLess, countEqual);
    }
    
    private static class MyList extends AbstractList<Integer> {
        private final int start;
        private final int size;

        public MyList(int start, int size) {
            this.start = start;
            this.size = size;
        }

        @Override
        public Integer get(int index) {
            return start + index;
        }

        @Override
        public int size() {
            return size;
        }
    }
}
