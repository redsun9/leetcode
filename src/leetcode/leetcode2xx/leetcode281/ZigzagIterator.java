package leetcode.leetcode2xx.leetcode281;

import java.util.List;

@SuppressWarnings("unchecked")
public class ZigzagIterator {
    private final List<Integer>[] v;
    private int pos = 0;
    private final int last;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = new List[]{v1, v2};
        this.last = Math.max(v1.size() * 2 - 1, v2.size() * 2);
    }


    public int next() {
        if (v[pos & 1].size() <= (pos >>> 1)) pos++;
        return v[pos & 1].get(pos++ >>> 1);
    }


    public boolean hasNext() {
        return pos < last;
    }
}
