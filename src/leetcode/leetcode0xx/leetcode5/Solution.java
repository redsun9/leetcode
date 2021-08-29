package leetcode.leetcode0xx.leetcode5;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int[] d1 = manacherOdd(s), d2 = manacherEven(s);

        int max1 = 0, index1 = 0, max2 = 0, index2 = 0;
        for (int i = 0; i < n; i++) {
            if (d1[i] > max1) {
                max1 = d1[i];
                index1 = i;
            }
            if (d2[i] > max2) {
                max2 = d2[i];
                index2 = i;
            }
        }

        if (max2 >= max1) return s.substring(index2 - max2, index2 + max2);
        else return s.substring(index1 - max1 + 1, index1 + max1);
    }

    //number of palindromes of odd length with center at i
    private static int[] manacherOdd(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(ans[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        return ans;
    }

    //number of palindromes of even length with center at i
    private static int[] manacherEven(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(ans[l + r - i + 1], r - i + 1);
            while (i - k - 1 >= 0 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
        return ans;
    }
}
