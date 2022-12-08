package leetcode.leetcode24xx.leetcode2490;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(n - 1)) return false;
        int pos = sentence.indexOf(' ');
        while (pos != -1) {
            if (sentence.charAt(pos - 1) != sentence.charAt(pos + 1)) return false;
            pos = sentence.indexOf(' ', pos + 1);
        }
        return true;
    }
}
