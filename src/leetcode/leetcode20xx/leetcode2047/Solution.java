package leetcode.leetcode20xx.leetcode2047;

public class Solution {
    public int countValidWords(String sentence) {
        int ans = 0, n = sentence.length();

        int left = 0;
        while (left < n) {
            boolean ok = true;
            int right = left, lastHyphen = left - 1, lastPunct = left - 1;
            while (right < n) {
                char c = sentence.charAt(right);
                if (c == ' ') break;
                if (c >= '0' && c <= '9') ok = false;
                else if (c == '-') {
                    ok &= lastHyphen < left;
                    lastHyphen = right;
                } else if (c == '!' || c == '.' || c == ',') {
                    ok &= lastPunct < left;
                    lastPunct = right;
                }
                right++;
            }

            if (
                    ok && right - left >= 1
                            && (lastHyphen < left || lastHyphen > left && lastHyphen < right - 1)
                            && (lastPunct < left || lastPunct == right - 1)
                            && (lastHyphen < left || lastPunct < left || lastHyphen < right - 2)
            ) ans++;

            left = right + 1;
        }
        return ans;
    }
}
