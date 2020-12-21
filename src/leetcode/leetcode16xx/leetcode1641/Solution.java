package leetcode.leetcode16xx.leetcode1641;

public class Solution {
    // f(n) = binomial(4,n+4)
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
