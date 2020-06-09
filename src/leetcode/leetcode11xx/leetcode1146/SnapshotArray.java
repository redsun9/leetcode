package leetcode.leetcode11xx.leetcode1146;

import java.util.*;

public class SnapshotArray {
    private int counter = 0;
    private int snapshot = 0;
    private final ArrayList<Integer> snapshots = new ArrayList<>();
    private final TreeMap<Pair, Integer> map = new TreeMap<>(
            Comparator.comparingInt((Pair x) -> x.index).thenComparingInt(x -> x.time)
    );

    public SnapshotArray(int length) {
    }

    public void set(int index, int val) {
        Pair pair = new Pair(index, counter++);
        map.put(pair, val);
    }

    public int snap() {
        snapshots.add(counter++);
        return snapshot++;
    }

    public int get(int index, int snapId) {
        Map.Entry<Pair, Integer> entry = map.floorEntry(new Pair(index, snapshots.get(snapId)));
        if (entry == null || entry.getKey().index != index) return 0;
        else return entry.getValue();
    }

    private static class Pair {
        int index;
        int time;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index &&
                    time == pair.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, time);
        }

        public Pair(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
