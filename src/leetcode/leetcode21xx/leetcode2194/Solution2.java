package leetcode.leetcode21xx.leetcode2194;

import java.util.AbstractList;
import java.util.List;

public class Solution2 {
    public List<String> cellsInRange(String s) {
        return new MyList(s);
    }

    private static class MyList extends AbstractList<String> {
        final char c1, r1;
        final int rows, cols;

        MyList(String s) {
            c1 = s.charAt(0);
            r1 = s.charAt(1);
            cols = s.charAt(3) - c1 + 1;
            rows = s.charAt(4) - r1 + 1;
        }


        @Override
        public String get(int index) {
            return (char) (c1 + index / rows) + "" + (char) (r1 + index % rows);
        }

        @Override
        public int size() {
            return rows * cols;
        }
    }
}
