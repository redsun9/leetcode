package leetcode.leetcode21xx.leetcode2120;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

// O(M*logM)

@SuppressWarnings("ConstantConditions")
public class Solution {
    private static final int MAX_N = 500, MAX_M = 500;

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length(), x0 = startPos[1], y0 = startPos[0];
        Comparator<Pair> ceilComparator = Comparator.comparingInt(Pair::val)
                .thenComparingInt(Pair::idx);
        Comparator<Pair> floorComparator = Comparator.<Pair>comparingInt(pair -> -pair.val)
                .thenComparingInt(pair -> pair.idx);

        TreeSet<Pair> leftSet = new TreeSet<>(floorComparator);
        TreeSet<Pair> rightSet = new TreeSet<>(ceilComparator);
        TreeSet<Pair> topSet = new TreeSet<>(floorComparator);
        TreeSet<Pair> bottomSet = new TreeSet<>(ceilComparator);

        Pair maxPair = new Pair(MAX_N + MAX_M, m), minPair = new Pair(-(MAX_N + MAX_M), m);
        leftSet.add(minPair);
        rightSet.add(maxPair);
        topSet.add(minPair);
        bottomSet.add(maxPair);

        for (int i = 0, dx = 0, dy = 0; i < m; i++) {
            switch (s.charAt(i)) {
                case 'L' -> leftSet.add(new Pair(--dx, i));
                case 'R' -> rightSet.add(new Pair(++dx, i));
                case 'U' -> topSet.add(new Pair(--dy, i));
                case 'D' -> bottomSet.add(new Pair(++dy, i));
            }
        }

        int[] ans = new int[m];
        int tmp;
        Arrays.fill(ans, m);
        for (int i = 0, dx = 0, dy = 0; i < m; i++) {
            tmp = leftSet.ceiling(new Pair(-1 - (x0 - dx), i)).idx;
            if (tmp >= i) ans[i] = Math.min(tmp, ans[i]);
            tmp = rightSet.ceiling(new Pair(n - (x0 - dx), i)).idx;
            if (tmp >= i) ans[i] = Math.min(tmp, ans[i]);
            tmp = topSet.ceiling(new Pair(-1 - (y0 - dy), i)).idx;
            if (tmp >= i) ans[i] = Math.min(tmp, ans[i]);
            tmp = bottomSet.ceiling(new Pair(n - (y0 - dy), i)).idx;
            if (tmp >= i) ans[i] = Math.min(tmp, ans[i]);
            ans[i] -= i;
            switch (s.charAt(i)) {
                case 'L' -> --dx;
                case 'R' -> ++dx;
                case 'U' -> --dy;
                case 'D' -> ++dy;
            }
        }

        return ans;
    }


    private record Pair(int val, int idx) {
    }
}
