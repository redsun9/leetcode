package leetcode.leetcode24xx.leetcode2483;

public class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int minPenalty = 0, ans = 0;
        for (int i = 0; i < n; i++) if (customers.charAt(i) == 'Y') minPenalty++;
        for (int i = 0, curr = minPenalty; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                if (minPenalty > --curr) {
                    minPenalty = curr;
                    ans = i + 1;
                }
            } else curr++;
        }
        return ans;
    }
}
