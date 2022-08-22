package leetcode.leetcode9xx.leetcode936;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] sc = stamp.toCharArray(), tc = target.toCharArray();
        int slen = sc.length, tlen = target.length() - slen + 1, i, j;
        List<Integer> ansList = new LinkedList<>();
        boolean tdiff = true, sdiff;
        while (tdiff) {
            for (i = 0, tdiff = false; i < tlen; i++) {
                for (j = 0, sdiff = false; j < slen; j++) {
                    if (tc[i + j] == '?') continue;
                    if (tc[i + j] != sc[j]) break;
                    sdiff = true;
                }
                if (j == slen && sdiff) {
                    for (j = i, tdiff = true; j < slen + i; j++) tc[j] = '?';
                    ansList.add(0, i);
                }
            }
        }
        for (i = 0; i < tc.length; i++) if (tc[i] != '?') return new int[]{};
        int[] ans = new int[ansList.size()];
        for (i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }
}
