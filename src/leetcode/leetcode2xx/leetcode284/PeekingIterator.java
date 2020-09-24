package leetcode.leetcode2xx.leetcode284;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (next == null) next = iterator.next();
        return next;
    }


    @Override
    public boolean hasNext() {
        return next != null || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (next != null) {
            Integer val = next;
            next = null;
            return val;
        } else return iterator.next();
    }
}
