package leetcode.leetcode21xx.leetcode2169;

public class Solution {
    public int countOperations(int num1, int num2) {
        int ans = 0;
        int min = Math.min(num1, num2), max = Math.max(num1, num2), tmp;
        while (min != 0) {
            ans += max / min;
            tmp = max % min;
            max = min;
            min = tmp;
        }
        return ans;
    }
}
