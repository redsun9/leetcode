package suggestions.longest_special_subsequence;

//You are given a string S of the length n consisting of only lowercase alphabets.
// If the two consecutive characters in a subsequence have a difference that is no more than k,
// then it is called a Special Subsequence.
// Find the length of the longest special subsequence.

// Time complexity: O(n*k), Space complexity: O(ALPHABET_SIZE)
// Time complexity can be considered as O(n) for small alphabets
public class Solution {
    private static final int ALPHA_SIZE = 26;

    public int longestSpecialSubsequence(String s, int k) {
        int n = s.length();
        if (k >= ALPHA_SIZE - 1) return n;
        int[] dp = new int[ALPHA_SIZE]; // dp[i] = length of the longest special subsequence ending with i
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int max = 0;
            for (int j = Math.max(0, c - k); j <= Math.min(ALPHA_SIZE - 1, c + k); j++) max = Math.max(max, dp[j]);
            dp[c] = max + 1;
        }

        int ans = 0;
        for (int i = 0; i < ALPHA_SIZE; i++) ans = Math.max(ans, dp[i]);
        return ans;
    }
}
