package leetcode.leetcode15xx.leetcode1523;

public class Solution {
    public int countOdds(int low, int high) {
        if ((low & 1) == 1) low--;
        if ((high & 1) == 1) high++;
        return (high - low) >> 1;
    }
}
