package help_requests.rate_limiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RateLimiterTest {
    @Test
    void testLeakyBucket() {
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(2, 10);
        assertTrue(rateLimiter.isAllowed("a", 0));
        assertTrue(rateLimiter.isAllowed("a", 1));
        assertFalse(rateLimiter.isAllowed("a", 2));
        assertTrue(rateLimiter.isAllowed("a", 13));
        assertTrue(rateLimiter.isAllowed("a", 14));
        assertFalse(rateLimiter.isAllowed("a", 15));
        assertFalse(rateLimiter.isAllowed("a", 16));
    }

}