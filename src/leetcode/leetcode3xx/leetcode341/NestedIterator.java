package leetcode.leetcode3xx.leetcode341;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private final Stack<ListIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return stack.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger x = stack.peek().next();
                if (x.isInteger())
                    return stack.peek().previous() == x;
                stack.push(x.getList().listIterator());
            }
        }
        return false;
    }
}
