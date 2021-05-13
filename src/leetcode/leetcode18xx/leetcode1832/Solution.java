package leetcode.leetcode18xx.leetcode1832;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        if (n < 26) return false;
        int ans = 0;
        for (int i = 0; i < n; i++) ans |= 1 << (sentence.charAt(i) - 'a');
        return ans == (1 << 26) - 1;
    }
}
