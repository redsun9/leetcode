package leetcode.leetcode12xx.leetcode1281;

public class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int prod = 1;

        while (n != 0) {
            int i = n % 10;
            sum += i;
            prod *= i;
            n /= 10;
        }
        return prod - sum;
    }
}
