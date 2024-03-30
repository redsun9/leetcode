package leetcode.leetcode30xx.leetcode3019;

public class Solution {
    public int countKeyChanges(String s) {
        int diff = 'A' - 'a', ans = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            int a = s.charAt(i - 1), b = s.charAt(i);
            if (a != b && a + diff != b && b + diff != a) ans++;
        }
        return ans;
    }
}
