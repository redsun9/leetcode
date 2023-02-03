package help_requests.rate_limiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QueueRateLimiter {
    private final int maxRequests;
    private final long timeWindow;
    private final Map<String, Deque<Long>> map = new HashMap<>();

    public QueueRateLimiter(int maxRequests, long timeWindow) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindow;
    }

    public boolean isAllowed(String userId, long timestamp) {
        Deque<Long> queue = map.computeIfAbsent(userId, k -> new ArrayDeque<>(maxRequests));
        while (!queue.isEmpty() && timestamp - queue.peekFirst() > timeWindow) queue.pollFirst();
        if (queue.size() >= maxRequests) return false;
        queue.addLast(timestamp);
        return true;
    }
}
