package leetcode.leetcode39xx.leetcode3941;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int passwordStrength(String password) {
        char[] special = {'!', '@', '#', '$'};
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < password.length(); i++) set.add(password.charAt(i));
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) if (set.contains(c)) ans += 1;
        for (char c = 'A'; c <= 'Z'; c++) if (set.contains(c)) ans += 2;
        for (char c = '0'; c <= '9'; c++) if (set.contains(c)) ans += 3;
        for (char c : special) if (set.contains(c)) ans += 5;
        return ans;
    }
}
