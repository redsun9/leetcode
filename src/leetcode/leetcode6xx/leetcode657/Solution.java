package leetcode.leetcode6xx.leetcode657;

public class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if (n == 0) return true;
        if ((n & 1) != 0) return false;
        int i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            switch (moves.charAt(k)) {
                case 'R' -> i++;
                case 'L' -> i--;
                case 'U' -> j++;
                case 'D' -> j--;
            }
        }
        return i == 0 && j == 0;
    }
}
