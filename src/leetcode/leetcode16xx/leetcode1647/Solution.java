package leetcode.leetcode16xx.leetcode1647;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) counts[s.charAt(i) - 'a']++;
        Set<Integer> used = new HashSet<>();
        int ans = 0;
        for (int count : counts) {
            while (count > 0 && !used.add(count)) {
                count--;
                ans++;
            }
        }
        return ans;
    }
}
