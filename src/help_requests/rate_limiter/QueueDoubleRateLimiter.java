package help_requests.rate_limiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QueueDoubleRateLimiter {
    private final int maxRequestsUnlimitedSpeed;
    private final long timeWindow;
    private final int maxRequestsLimitedSpeed;
    private final Map<String, Deque<Long>> map = new HashMap<>();
    private final Map<String, Deque<Long>> fallbackMap = new HashMap<>();

    public QueueDoubleRateLimiter(int maxRequestsUnlimitedSpeed, int maxRequestsLimitedSpeed, long timeWindow) {
        this.maxRequestsUnlimitedSpeed = maxRequestsUnlimitedSpeed;
        this.maxRequestsLimitedSpeed = maxRequestsLimitedSpeed - maxRequestsUnlimitedSpeed;
        this.timeWindow = timeWindow;
    }

    public boolean isAllowed(String userId, long timestamp) {
        Deque<Long> queue = map.computeIfAbsent(userId, k -> new ArrayDeque<>(maxRequestsUnlimitedSpeed));
        while (!queue.isEmpty() && timestamp - queue.peekFirst() > timeWindow) queue.pollFirst();
        if (queue.size() >= maxRequestsUnlimitedSpeed) {
            Deque<Long> fallbackQueue = fallbackMap.computeIfAbsent(userId, k -> new ArrayDeque<>(maxRequestsLimitedSpeed));
            while (!fallbackQueue.isEmpty() && timestamp - fallbackQueue.peekFirst() > timeWindow) {
                fallbackQueue.pollFirst();
            }
            if (fallbackQueue.size() >= maxRequestsLimitedSpeed) return false;
            fallbackQueue.addLast(timestamp);
        } else {
            queue.addLast(timestamp);
        }
        return true;

    }
}
