package leetcode.leetcode18xx.leetcode1825;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

public class MKAverage {
    private final MultiSet top = new MultiSet(), middle = new MultiSet(), bottom = new MultiSet();
    private final Queue<Integer> queue;
    long middleSum;
    int m, k, countTop, countBottom;

    public MKAverage(int m, int k) {
        this.queue = new ArrayDeque<>(m);
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (queue.size() == m) {
            int pop = queue.poll();
            if (top.contains(pop)) {
                top.remove(pop);
                countTop--;
            } else if (middle.contains(pop)) {
                middle.remove(pop);
                middleSum -= pop;
            } else {
                bottom.remove(pop);
                countBottom--;
            }
        }
        middle.add(num);
        queue.offer(num);
        middleSum += num;
        while (countTop < k && !middle.isEmpty()) {
            countTop++;
            middleSum -= middle.last();
            top.add(middle.remove(middle.last()));
        }
        while (!middle.isEmpty() && !top.isEmpty() && top.first() < middle.last()) {
            middleSum += top.first();
            middle.add(top.remove(top.first()));
            middleSum -= middle.last();
            top.add(middle.remove(middle.last()));
        }
        while (countBottom < k && !middle.isEmpty()) {
            countBottom++;
            middleSum -= middle.first();
            bottom.add(middle.remove(middle.first()));
        }
        while (!middle.isEmpty() && !bottom.isEmpty() && bottom.last() > middle.first()) {
            middleSum += bottom.last();
            middle.add(bottom.remove(bottom.last()));
            middleSum -= middle.first();
            bottom.add(middle.remove(middle.first()));
        }
    }

    public int calculateMKAverage() {
        return queue.size() == m ? (int) (middleSum / (m - 2 * k)) : -1;
    }


    private static class MultiSet {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();

        int remove(int num) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) map.remove(num);
            return num;
        }

        void add(int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        boolean contains(int num) {
            return map.containsKey(num);
        }

        int first() {
            return map.firstKey();
        }

        int last() {
            return map.lastKey();
        }

        boolean isEmpty() {
            return map.isEmpty();
        }
    }
}
