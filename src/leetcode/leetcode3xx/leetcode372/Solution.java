package leetcode.leetcode3xx.leetcode372;

import java.util.HashMap;

public class Solution {
    public static final int m = 1337;

    public int superPow(int a, int[] b) {
        a %= m;
        if (b.length == 1 && b[0] == 0) return 1;
        if (a == 0) return 0;
        //find cycle
        HashMap<Integer, Integer> modToPowers = new HashMap<>();
        modToPowers.put(1, 0);
        int[] mods = new int[m];
        mods[0] = 1;

        int i = 0, tmp = 1;
        int cycleStart, cycleLength;
        while (true) {
            i++;
            tmp = tmp * a % m;
            if (modToPowers.containsKey(tmp)) {
                cycleStart = modToPowers.get(tmp);
                cycleLength = i - cycleStart;
                break;
            } else {
                modToPowers.put(tmp, i);
                mods[i] = tmp;
            }
        }

        boolean biggerThanCycleStart = false;
        int bVal = 0;
        for (int bDigit : b) {
            bVal = bVal * 10 + bDigit;
            biggerThanCycleStart |= bVal > cycleStart;
            if (biggerThanCycleStart) bVal %= cycleLength;
        }

        if (!biggerThanCycleStart) return mods[bVal];
        else return mods[(bVal - cycleStart) % cycleLength + cycleStart];
    }
}
