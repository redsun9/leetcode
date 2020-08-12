package leetcode.leetcode1xx.leetcode167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (true) {
            int tmp = numbers[lo] + numbers[hi];
            if (tmp == target) break;
            if (tmp < target) lo++;
            else hi--;
        }
        return new int[]{lo + 1, hi + 1};
    }
}
