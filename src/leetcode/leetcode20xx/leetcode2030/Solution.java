package leetcode.leetcode20xx.leetcode2030;

public class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int occurrencesLeft = 0;
        for (char c : arr) if (c == letter) occurrencesLeft++;

        int ansLeft = 0;
        for (char c : arr) {
            while (
                    ansLeft != 0 && arr[ansLeft - 1] > c && n + ansLeft > k
                            && (arr[ansLeft - 1] != letter || occurrencesLeft > repetition)
            ) if (arr[--ansLeft] == letter) repetition++;
            if (ansLeft < k) {
                if (c == letter) {
                    arr[ansLeft++] = c;
                    repetition--;
                } else if (k - ansLeft > repetition) {
                    arr[ansLeft++] = c;
                }
            }

            if (c == letter) occurrencesLeft--;
            n--;
        }
        return new String(arr, 0, k);
    }
}
