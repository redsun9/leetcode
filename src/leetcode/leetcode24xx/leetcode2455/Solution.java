package leetcode.leetcode24xx.leetcode2455;

public class Solution {
    public int averageValue(int[] nums) {
        int sum = 0, cnt = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                cnt++;
            }
        }
        if (cnt == 0) return 0;
        else return sum / cnt;
    }
}
