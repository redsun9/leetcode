package leetcode.leetcode8xx.leetcode844;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            int toDelete = 0;
            while (i >= 0 && (toDelete > 0 || s.charAt(i) == '#')) {
                if (s.charAt(i) == '#') toDelete++;
                else toDelete--;
                i--;
            }
            toDelete = 0;
            while (j >= 0 && (toDelete > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') toDelete++;
                else toDelete--;
                j--;
            }
            if (
                    (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) ||
                            (i < 0 ^ j < 0)
            ) return false;
            i--;
            j--;
        }
        return true;
    }
}
