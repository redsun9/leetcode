package leetcode.leetcode36xx.leetcode3692;

public class Solution {
    public String majorityFrequencyGroup(String s) {
        int maxPossible = 100;
        int[] charFreqs = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) charFreqs[s.charAt(i) - 'a']++;

        int[] freqGroupSizes = new int[maxPossible + 1];
        for (int charFreq : charFreqs) freqGroupSizes[charFreq]++;

        int maxFreqGroup = 1;
        for (int i = 1; i <= maxPossible; i++) {
            if (freqGroupSizes[i] >= freqGroupSizes[maxFreqGroup]) maxFreqGroup = i;
        }

        char[] ans = new char[freqGroupSizes[maxFreqGroup]];
        for (int i = 0, pos = 0; i < 26; i++) {
            if (charFreqs[i] == maxFreqGroup) {
                ans[pos++] = (char) ('a' + i);
            }
        }
        return new String(ans);
    }
}
