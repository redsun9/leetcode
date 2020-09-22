package leetcode.leetcode9xx.leetcode970;

import java.util.*;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (bound >= 2) {
            Set<Integer> set = new HashSet<>();
            if (x < y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            if (y > 1) {
                for (int tmp1 = 1; tmp1 < bound; tmp1 *= x)
                    for (int tmp2 = 1; tmp1 + tmp2 <= bound; tmp2 *= y)
                        set.add(tmp1 + tmp2);
            } else if (x > 1) {
                for (int tmp = 1; tmp < bound; tmp *= x)
                    set.add(tmp + 1);
            } else set.add(2);

            return new ArrayList<>(set);
        } else return Collections.emptyList();
    }
}
