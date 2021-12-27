package leetcode.leetcode21xx.leetcode2116;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) != 0) return false;
        int defaultBalance = 0, totalUnlocked = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') defaultBalance++;
                else defaultBalance--;
            } else totalUnlocked++;
        }

        if (Math.abs(defaultBalance) > totalUnlocked) return false;
        int unlockedToOpen = (totalUnlocked - defaultBalance) / 2;

        for (int i = 0, balance = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') balance++;
                else balance--;
            } else {
                if (unlockedToOpen-- > 0) balance++;
                else balance--;
            }
            if (balance < 0) return false;
        }
        return true;
    }
}
