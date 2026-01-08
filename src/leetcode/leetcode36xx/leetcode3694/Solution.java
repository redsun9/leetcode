package leetcode.leetcode36xx.leetcode3694;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        Set<Pair> set = new HashSet<>();
        for (int i = 0, dx = 0, dy = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'U' -> dy++;
                case 'D' -> dy--;
                case 'L' -> dx--;
                case 'R' -> dx++;
            }
            if (i >= k) {
                c = s.charAt(i - k);
                switch (c) {
                    case 'U' -> dy--;
                    case 'D' -> dy++;
                    case 'L' -> dx++;
                    case 'R' -> dx--;
                }
            }

            if (i >= k - 1) set.add(new Pair(dx, dy));
        }
        return set.size();
    }

    private record Pair(int dx, int dy) {
    }
}
