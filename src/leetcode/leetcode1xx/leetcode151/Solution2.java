package leetcode.leetcode1xx.leetcode151;

public class Solution2 {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = trim(a);
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == ' ') {
                reverse(a, start, i);
                start = i + 1;
            }
        }
        reverse(a, start, n);
        reverse(a, 0, n);
        return new String(a, 0, n);
    }

    private static int trim(char[] a) {
        int n = a.length;
        int firstIndex = 0;
        while (firstIndex < n && Character.isWhitespace(a[firstIndex])) firstIndex++;
        if (firstIndex == n) return 0;
        int lastIndex = n - 1;
        while (Character.isWhitespace(a[lastIndex])) lastIndex--;
        int ans = 0;
        while (firstIndex <= lastIndex && !Character.isWhitespace(a[firstIndex])) a[ans++] = a[firstIndex++];
        while (firstIndex <= lastIndex) {
            a[ans++] = ' ';
            while (Character.isWhitespace(a[firstIndex])) firstIndex++;
            while (firstIndex <= lastIndex && !Character.isWhitespace(a[firstIndex])) a[ans++] = a[firstIndex++];
        }
        return ans;
    }

    private static void reverse(char[] a, int start, int end) {
        for (; start < --end; start++) {
            char tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
        }
    }
}
