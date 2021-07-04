package leetcode.leetcode8xx.leetcode855;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import static java.util.Comparator.comparingInt;

public class ExamRoom {
    private static final Comparator<Interval> comparator =
            comparingInt((Interval x) -> -x.dist)
                    .thenComparingInt(x -> x.seat);
    private final int n;
    private HashMap<Integer, Interval> leftMap = new HashMap<>();
    private HashMap<Integer, Interval> rightMap = new HashMap<>();
    private TreeSet<Interval> set = new TreeSet<>(comparator);


    public ExamRoom(int n) {
        this.n = n;
        Interval interval = new Interval(-1, n, n, 0);
        set.add(interval);
        leftMap.put(interval.left, interval);
        rightMap.put(interval.right, interval);

        Interval lb = new Interval(-2, -1, 0, -2);
        set.add(lb);
        leftMap.put(lb.left, lb);
        rightMap.put(lb.right, lb);

        Interval rb = new Interval(n, n + 1, 0, -2);
        leftMap.put(rb.left, rb);
        rightMap.put(rb.right, rb);
    }

    public int seat() {
        Iterator<Interval> iterator = set.iterator();
        Interval a = iterator.next();
        iterator.remove();
        int l = a.left, m = a.seat, r = a.right;
        Interval left = new Interval(
                l, m,
                l == -1 ? m : (m - l) / 2,
                l == -1 ? 0 : l + (m - l) / 2
        );
        set.add(left);
        leftMap.put(l, left);
        rightMap.put(m, left);

        Interval right = new Interval(
                m, r,
                r == n ? n - 1 - m : (r - m) / 2,
                r == n ? n - 1 : m + (r - m) / 2
        );
        set.add(right);
        leftMap.put(m, right);
        rightMap.put(r, right);
        return m;
    }

    public void leave(int p) {
        Interval left = rightMap.remove(p);
        Interval right = leftMap.remove(p);
        set.remove(left);
        set.remove(right);
        int l = left.left, r = right.right;
        Interval sum = new Interval(
                l, r,
                l == -1 ? r : r == n ? n - 1 - l : (r - l) / 2,
                l == -1 ? 0 : r == n ? n - 1 : l + (r - l) / 2
        );
        set.add(sum);
        leftMap.put(sum.left, sum);
        rightMap.put(sum.right, sum);
    }

    private static class Interval {
        int left, right, dist, seat;

        public Interval(int left, int right, int dist, int seat) {
            this.left = left;
            this.right = right;
            this.dist = dist;
            this.seat = seat;
        }
    }
}
