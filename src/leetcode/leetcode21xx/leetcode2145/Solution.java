package leetcode.leetcode21xx.leetcode2145;

public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long curr = 0, min = 0, max = 0;
        for (int difference : differences) {
            curr += difference;
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }
}
