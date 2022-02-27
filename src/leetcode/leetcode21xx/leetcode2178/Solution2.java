package leetcode.leetcode21xx.leetcode2178;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) != 0) return Collections.emptyList();
        finalSum >>= 1;
        long x = Math.round((Math.sqrt(8 * finalSum + 1) - 1) / 2);
        if (x * (x + 1) / 2 > finalSum) x--;
        finalSum <<= 1;
        return new MyList((int) x, (int) (finalSum - x * (x - 1)));
    }

    private static class MyList extends AbstractList<Long> {
        final int size, last;

        private MyList(int size, int last) {
            this.size = size;
            this.last = last;
        }

        @Override
        public Long get(int index) {
            return index + 1 == size ? last : 2L * (index + 1);
        }

        @Override
        public int size() {
            return size;
        }
    }
}
