package leetcode.leetcode16xx.leetcode1616;

public class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private static boolean check(String a, String b) {
        int start = 0, end = a.length() - 1;
        while (start < end && a.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        return check(a, start, end) || check(b, start, end);

    }

    private static boolean check(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
