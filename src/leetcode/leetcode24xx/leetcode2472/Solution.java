package leetcode.leetcode24xx.leetcode2472;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1) return n;
        int[] odd = manacherOdd(s), even = manacherEven(s);
        int minOddLength = k + 1 - (k & 1), minEvenLength = k + (k & 1);
        int minOddVal = (minOddLength >> 1) + 1, minEvenVal = minEvenLength >> 1;
        int[] dp = new int[n + 1];
        for (int i = 0,
             midOdd = -minOddVal + 1, oddLeft = -minOddLength + 1,
             midEven = -minEvenVal + 1, evenLeft = -minEvenLength + 1;
             i < n; i++, midOdd++, oddLeft++, midEven++, evenLeft++
        ) {
            dp[i + 1] = dp[i];
            if (oddLeft >= 0 && odd[midOdd] >= minOddVal) dp[i + 1] = Math.max(dp[oddLeft] + 1, dp[i + 1]);
            if (evenLeft >= 0 && even[midEven] >= minEvenVal) dp[i + 1] = Math.max(dp[evenLeft] + 1, dp[i + 1]);
        }
        return dp[n];
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
