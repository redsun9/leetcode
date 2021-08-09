package leetcode.leetcode9xx.leetcode904;

public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n <= 2) return n;
        int ans = 0;
        for (int i = 1, start = 0, num1 = -1, num2 = fruits[0], last1 = -1, last2 = 0; i < n; i++) {
            if (fruits[i] == num1) last1 = i;
            else if (fruits[i] == num2) last2 = i;
            else {
                start = Math.min(last1, last2) + 1;
                if (last1 < last2) {
                    last1 = i;
                    num1 = fruits[i];
                } else {
                    last2 = i;
                    num2 = fruits[i];
                }
            }
            ans = Math.max(ans, i - start);
        }
        return ans + 1;
    }
}
