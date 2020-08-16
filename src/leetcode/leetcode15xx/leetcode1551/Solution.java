package leetcode.leetcode15xx.leetcode1551;

public class Solution {
    public int minOperations(int n) {
        return (n >> 1) * ((n >> 1) + (n & 1));
    }
}
