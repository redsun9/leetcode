package leetcode.leetcode20xx.leetcode2034;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class StockPrice {
    PriorityQueue<Pair> maxPrice = new PriorityQueue<>(Comparator.comparingInt(x -> -x.price));
    PriorityQueue<Pair> minPrice = new PriorityQueue<>(Comparator.comparingInt(x -> x.price));
    PriorityQueue<Pair> current = new PriorityQueue<>(Comparator.comparingInt(x -> -x.timestamp));
    HashMap<Integer, Integer> actual = new HashMap<>();

    public void update(int timestamp, int price) {
        actual.put(timestamp, price);
        Pair pair = new Pair(price, timestamp);
        maxPrice.offer(pair);
        minPrice.offer(pair);
        current.offer(pair);

    }

    public int current() {
        while (actual.get(current.peek().timestamp) != current.peek().price) current.poll();
        return current.peek().price;

    }

    public int maximum() {
        while (actual.get(maxPrice.peek().timestamp) != maxPrice.peek().price) maxPrice.poll();
        return maxPrice.peek().price;
    }

    public int minimum() {
        while (actual.get(minPrice.peek().timestamp) != minPrice.peek().price) minPrice.poll();
        return minPrice.peek().price;
    }


    private static class Pair {
        final int price, timestamp;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return price == pair.price && timestamp == pair.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, timestamp);
        }

        public Pair(int price, int timestamp) {
            this.price = price;
            this.timestamp = timestamp;
        }
    }
}
