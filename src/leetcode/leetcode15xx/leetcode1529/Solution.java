package leetcode.leetcode15xx.leetcode1529;

public class Solution {
    public int minFlips(String target) {
        int ans = 0;
        boolean prev = false;
        for (int i = 0; i < target.length(); i++) {
            boolean curr = target.charAt(i) == '1';
            if (prev != curr) ans++;
            prev = curr;
        }
        return ans;
    }
}
