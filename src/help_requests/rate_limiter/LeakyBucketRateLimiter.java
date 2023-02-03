package help_requests.rate_limiter;

import java.util.HashMap;
import java.util.Map;

public class LeakyBucketRateLimiter {
    private final int maxRequests;
    private final long timeWindow;
    private final Map<String, LeakyBucket> map = new HashMap<>();

    public LeakyBucketRateLimiter(int maxRequests, long timeWindow) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindow;
    }

    public boolean isAllowed(String userId, long timestamp) {
        LeakyBucket bucket = map.computeIfAbsent(userId, k -> new LeakyBucket(timestamp));
        return bucket.isAllowed(timestamp);
    }

    private class LeakyBucket {
        private long left;
        private long lastAddedTime;

        LeakyBucket(long lastAddedTime) {
            this.lastAddedTime = lastAddedTime;
            this.left = maxRequests;
        }

        public boolean isAllowed(long timestamp) {
            long additional = (timestamp - lastAddedTime) * maxRequests / timeWindow;
            if (additional > 0) {
                left = Math.min(left + additional, maxRequests);
                if (left == maxRequests) lastAddedTime = timestamp;
                else lastAddedTime += additional * timeWindow / maxRequests;
            }
            if (left > 0) {
                left--;
                return true;
            }
            return false;
        }
    }


}
