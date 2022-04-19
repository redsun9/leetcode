package leetcode.leetcode16xx.leetcode1694;

public class Solution {
    public String reformatNumber(String number) {
        int n = number.length();
        char[] ans = new char[n + n / 3 + 1];
        int numOfDigits = 0, charStart = ans.length;
        for (int i = n - 1; i >= 0; i--) {
            char c = number.charAt(i);
            if (c >= '0' && c <= '9') {
                ans[--charStart] = c;
                numOfDigits++;
            }
        }
        int ansLen = 0;
        while (numOfDigits > 4) {
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = '-';
            numOfDigits -= 3;
        }
        if (numOfDigits == 2) {
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart];
        } else if (numOfDigits == 3) {
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart];
        } else if (numOfDigits == 4) {
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = '-';
            ans[ansLen++] = ans[charStart++];
            ans[ansLen++] = ans[charStart];
        }
        return new String(ans, 0, ansLen);
    }
}
