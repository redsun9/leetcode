package leetcode.leetcode14xx.leetcode1400;

public class Solution {
    public boolean canConstruct(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddCount = 0;
        for (int i : count) {
            if ((i & 1) == 1) oddCount++;
        }
        return s.length() >= k && oddCount <= k;
    }
}
