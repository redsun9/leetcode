package help_requests.rate_limiter;

import java.util.HashMap;
import java.util.Map;

public class DoubleLeakyBucketRateLimiter {
    private final int maxRequestsUnlimitedSpeed;
    private final long timeWindow;
    private final int maxRequestsLimitedSpeed;
    private final Map<String, LeakyBucket> map = new HashMap<>();

    public DoubleLeakyBucketRateLimiter(int maxRequestsUnlimitedSpeed, int maxRequestsLimitedSpeed, long timeWindow) {
        this.maxRequestsUnlimitedSpeed = maxRequestsUnlimitedSpeed;
        this.maxRequestsLimitedSpeed = maxRequestsLimitedSpeed - maxRequestsUnlimitedSpeed;
        this.timeWindow = timeWindow;
    }

    public boolean isAllowed(String userId, long timestamp) {
        LeakyBucket bucket = map.computeIfAbsent(userId, k -> new LeakyBucket(timestamp));
        return bucket.isAllowed(timestamp);
    }

    private class LeakyBucket {
        private long leftUnlimited = maxRequestsUnlimitedSpeed;
        private long leftLimited = maxRequestsLimitedSpeed;
        private long lastAddedTime;
        private long lastAddedTimeLimited;

        LeakyBucket(long timeStamp) {
            this.lastAddedTime = timeStamp;
            this.lastAddedTimeLimited = timeStamp;
        }

        public boolean isAllowed(long timestamp) {
            long additionalUnlimited = (timestamp - lastAddedTime) * maxRequestsUnlimitedSpeed / timeWindow;
            if (additionalUnlimited > 0) {
                leftUnlimited = Math.min(leftUnlimited + additionalUnlimited, maxRequestsUnlimitedSpeed);
                lastAddedTime = timestamp;
            }
            if (leftUnlimited > 0) {
                leftUnlimited--;
                return true;
            } else {
                long additionalLimited = (timestamp - lastAddedTimeLimited) * maxRequestsLimitedSpeed / timeWindow;
                if (additionalLimited > 0) {
                    leftLimited = Math.min(leftLimited + additionalLimited, maxRequestsLimitedSpeed);
                    lastAddedTimeLimited = timestamp;
                }
                if (leftLimited > 0) {
                    leftLimited--;
                    return true;
                }
                return false;
            }
        }
    }
}
