package leetcode.leetcode12xx.leetcode1276;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (
                ((tomatoSlices == 0) ^ (cheeseSlices == 0)) ||
                        tomatoSlices % 2 != 0 || cheeseSlices * 4 < tomatoSlices || cheeseSlices * 2 > tomatoSlices
        ) return Collections.emptyList();
        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int small = cheeseSlices - jumbo;
        return Arrays.asList(jumbo, small);
    }
}
