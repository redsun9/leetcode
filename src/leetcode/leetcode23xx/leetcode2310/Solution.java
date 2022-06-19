package leetcode.leetcode23xx.leetcode2310;

public class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        if (num % 2 != 0 && k % 2 == 0) return -1;
        if (num % 5 != 0 && k % 5 == 0) return -1;
        int ans = 1, min = k, digit = num % 10;
        while (min % 10 != digit) {
            min += k;
            ans++;
        }
        if (min > num) return -1;
        return ans;
    }
}
