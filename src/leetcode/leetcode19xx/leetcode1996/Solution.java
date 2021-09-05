package leetcode.leetcode19xx.leetcode1996;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, Comparator.comparingInt(x -> -x[0]));

        int ans = 0;
        int maxDefOfStronger = 0, maxDefOfSame = 0, previousAttack = Integer.MAX_VALUE;
        for (int[] property : properties) {
            if (property[0] != previousAttack) maxDefOfStronger = maxDefOfSame;
            if (maxDefOfStronger > property[1]) ans++;
            maxDefOfSame = Math.max(maxDefOfSame, property[1]);
            previousAttack = property[0];
        }
        return ans;
    }
}
