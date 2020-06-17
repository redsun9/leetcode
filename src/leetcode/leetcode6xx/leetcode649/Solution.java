package leetcode.leetcode6xx.leetcode649;

import java.util.ArrayDeque;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public static final String DIRE = "Dire";
    public static final String RADIANT = "Radiant";

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        ArrayDeque<Boolean> queue = new ArrayDeque<>(n);
        int curR = 0, curD = 0;
        for (int i = 0; i < n; i++) {
            boolean b = senate.charAt(i) == 'R';
            queue.addLast(b);
            if (b) curR++;
            else curD++;
        }
        int toSkip = 0; //positive  - dire to skip, negative - radiant to skip
        while (curR != 0 && curD != 0) {
            boolean polled = queue.pollFirst();
            if (polled) {
                toSkip++;
                if (toSkip > 0) queue.addLast(polled);
                else curR--;
            } else {
                toSkip--;
                if (toSkip < 0) queue.addLast(polled);
                else curD--;
            }
        }
        return curR != 0 ? RADIANT : DIRE;
    }
}
