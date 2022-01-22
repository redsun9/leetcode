package leetcode.leetcode21xx.leetcode2124;

public class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean bAppeared = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                if (bAppeared) return false;
            } else bAppeared = true;
        }
        return true;
    }
}
