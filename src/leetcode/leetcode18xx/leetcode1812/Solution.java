package leetcode.leetcode18xx.leetcode1812;

public class Solution {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) + coordinates.charAt(1)) & 1) == 1;
    }
}
