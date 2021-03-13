package leetcode.leetcode17xx.leetcode1780;

public class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n != 0 && n % 3 != 2) n /= 3;
        return n == 0;
    }
}
