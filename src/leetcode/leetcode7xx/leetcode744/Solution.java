package leetcode.leetcode7xx.leetcode744;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        if (lo == letters.length) return letters[0];
        else return letters[lo];
    }
}
