package leetcode.leetcode8xx.leetcode850;

import java.util.*;

// Line Sweep
// Time Complexity: O(N^2)
// Space Complexity: O(N)

public class Solution2 {
    private static final int p = 1_000_000_007;

    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        Event[] events = new Event[rectangles.length * 2];
        int t = 0;
        for (int[] rect : rectangles) {
            Pair pair = new Pair(rect[1], rect[3]);
            events[t++] = new Event(EventType.OPEN, rect[0], pair);
            events[t++] = new Event(EventType.CLOSE, rect[2], pair);
        }
        Arrays.sort(events, Comparator.comparingInt(event -> event.x));

        Map<Pair, Event> activeEvents = new TreeMap<>(Comparator.comparingInt((Pair pair) -> pair.y1)
                .thenComparingInt(x -> x.y2));
        Map<Pair, Integer> activeCount = new HashMap<>();
        int currentX = events[0].x;
        long ans = 0;
        for (Event event : events) {
            long query = 0;
            int max = Integer.MIN_VALUE;
            for (Pair pair : activeEvents.keySet()) {
                max = Math.max(max, pair.y1);
                query += Math.max(pair.y2 - max, 0);
                max = Math.max(max, pair.y2);
            }
            ans += query * (event.x - currentX);
            if (event.eventType == EventType.OPEN) {
                Integer value = activeCount.compute(event.y, (pair, val) -> val == null ? 1 : val + 1);
                if (value == 1) activeEvents.put(event.y, event);
            } else {
                Integer value = activeCount.compute(event.y, (pair, val) -> val == 1 ? null : val - 1);
                if (value == null) activeEvents.remove(event.y);
            }
            currentX = event.x;
        }
        return (int) (ans % p);
    }

    enum EventType {
        OPEN,
        CLOSE
    }

    private static class Event {
        private final EventType eventType;
        private final int x;
        private final Pair y;

        public Event(EventType eventType, int x, Pair y) {
            this.eventType = eventType;
            this.x = x;
            this.y = y;
        }
    }

    private static class Pair {
        private final int y1, y2;

        private Pair(int y1, int y2) {
            this.y1 = y1;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return y1 == pair.y1 &&
                    y2 == pair.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y1, y2);
        }
    }
}
