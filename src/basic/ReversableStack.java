package basic;

import java.util.LinkedList;

public class ReversableStack<T> {
    private boolean reversed = false;
    private final LinkedList<T> list = new LinkedList<>();

    public T getFromBeginning() {
        return reversed ? list.getLast() : list.getFirst();
    }

    public T getFromEnd() {
        return reversed ? list.getFirst() : list.getLast();
    }

    public T removeFromBeginning() {
        return reversed ? list.removeLast() : list.removeFirst();
    }

    public T removeFromEnd() {
        return reversed ? list.removeFirst() : list.removeLast();
    }

    public void addToBeginnging(T elem) {
        if (reversed)
            list.addLast(elem);
        else
            list.addFirst(elem);
    }

    public void addToEnd(T elem) {
        if (reversed)
            list.addFirst(elem);
        else
            list.addLast(elem);
    }

    public void reverse() {
        reversed = !reversed;
    }
}