package leetcode.leetcode23xx.leetcode2315;

public class Solution {
    public int countAsterisks(String s) {
        int n = s.length(), ans = 0;
        boolean toCount = true;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case '*' -> {
                    if (toCount) ans++;
                }
                case '|' -> toCount = !toCount;
            }
        }
        return ans;
    }
}
