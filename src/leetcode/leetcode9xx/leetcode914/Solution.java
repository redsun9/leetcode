package leetcode.leetcode9xx.leetcode914;

import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        HashMap<Integer, Integer> count = new HashMap<>();
        ;
        for (int i : deck) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        Iterator<Integer> iterator = count.values().iterator();
        Integer a = iterator.next();
        while (a > 1 && iterator.hasNext()) {
            Integer b = iterator.next();
            a = gcd(a, b);
        }
        return a != 1;
    }


    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }
}
