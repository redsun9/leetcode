package leetcode.leetcode7xx.leetcode789;

public class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x = target[0];
        int y = target[1];
        int d = Math.abs(x) + Math.abs(y);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - x) + Math.abs(ghost[1] - y) <= d) return false;
        }
        return true;
    }
}
