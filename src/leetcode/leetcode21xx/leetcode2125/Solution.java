package leetcode.leetcode21xx.leetcode2125;

public class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank.length <= 1) return 0;
        int ans = 0, n = bank[0].length(), prev = 0;
        for (String s : bank) {
            int curr = 0;
            for (int i = 0; i < n; i++) if (s.charAt(i) == '1') curr++;
            if (curr != 0) {
                ans += prev * curr;
                prev = curr;
            }
        }
        return ans;
    }
}
