package leetcode.leetcode23xx.leetcode2349;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {
    Map<Integer, Integer> map = new HashMap<>();
    TreeSet<Pair> set = new TreeSet<>(Comparator.<Pair>comparingInt(x -> x.val).thenComparingInt(x -> x.idx));

    public void change(int index, int number) {
        Integer prevVal = map.put(index, number);
        if (prevVal != null) {
            if (prevVal == number) return;
            set.remove(new Pair(prevVal, index));
        }
        set.add(new Pair(number, index));
    }

    public int find(int number) {
        Pair ceiling = set.ceiling(new Pair(number, 0));
        if (ceiling != null && ceiling.val == number) return ceiling.idx;
        else return -1;
    }


    private record Pair(int val, int idx) {
    }
}
