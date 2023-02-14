package help_requests.vip_queue;

import java.util.ArrayDeque;
import java.util.Deque;

// vip people stand in the middle of the queue
// non-vip people stand at the end of the queue
public class VipQueue {
    private final Deque<String> firstHalf = new ArrayDeque<>();
    private final Deque<String> secondHalf = new ArrayDeque<>();

    public void add(String id, boolean vip) {
        if (vip) firstHalf.addLast(id);
        else secondHalf.addLast(id);

        if (firstHalf.size() > secondHalf.size() + 1) secondHalf.addFirst(firstHalf.removeLast());
        else if (secondHalf.size() > firstHalf.size()) firstHalf.addLast(secondHalf.removeFirst());
    }

    public String get() {
        if (firstHalf.isEmpty()) return null;
        String id = firstHalf.removeFirst();
        if (firstHalf.size() < secondHalf.size()) firstHalf.addLast(secondHalf.removeFirst());
        return id;
    }
}
