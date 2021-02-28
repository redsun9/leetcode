package leetcode.leetcode17xx.leetcode1736;

public class Solution {
    public String maximumTime(String time) {
        char[] ans = new char[5];
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?' || time.charAt(1) >= '0' && time.charAt(1) <= '3') {
                ans[0] = '2';
            } else ans[0] = '1';
        } else ans[0] = time.charAt(0);

        if (time.charAt(1) == '?') {
            if (time.charAt(0) >= '0' && time.charAt(0) <= '1') {
                ans[1] = '9';
            } else ans[1] = '3';
        } else ans[1] = time.charAt(1);

        if (time.charAt(3) == '?') {
            ans[3] = '5';
        } else ans[3] = time.charAt(3);

        if (time.charAt(4) == '?') {
            ans[4] = '9';
        } else ans[4] = time.charAt(4);
        ans[2] = ':';
        return new String(ans);
    }
}
