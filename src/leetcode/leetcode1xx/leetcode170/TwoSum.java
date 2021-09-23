package leetcode.leetcode1xx.leetcode170;

import java.util.Iterator;
import java.util.TreeSet;

public class TwoSum {
    private TreeSet<Integer> ones = new TreeSet<>();
    private TreeSet<Integer> twos = new TreeSet<>();

    public void add(int number) {
        if (!ones.add(number)) twos.add(number);
    }

    public boolean find(int value) {
        if (ones.isEmpty()) return false;
        if ((value & 1) == 0 && twos.contains(value / 2)) return true;
        Iterator<Integer> inc = ones.iterator(), dec = ones.descendingIterator();
        long incValue = inc.next(), decValue = dec.next();
        while (incValue != decValue) {
            long sum = incValue + decValue;
            if (sum == value) return true;
            if (sum < value) incValue = inc.next();
            else if (sum > value) decValue = dec.next();
        }
        return false;
    }
}
