package leetcode.leetcode24xx.leetcode2491;

import java.util.Arrays;

public class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ans = 0;
        for (int i = 0, j = skill.length - 1, sum = skill[i] + skill[j]; i < j; i++, j--) {
            if (skill[i] + skill[j] != sum) return -1;
            ans += (long) skill[i] * skill[j];
        }
        return ans;
    }
}
