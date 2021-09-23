package leetcode.leetcode1xx.leetcode158;

public class Solution extends Reader4 {
    private char[] buf = new char[4];
    private int left = 0;

    Solution(char[] arr) {
        super(arr);
    }

    /**
     * @param buf destination buffer
     * @param n   maximum number of characters to read
     * @return the number of characters read
     */
    public int read(char[] buf, int n) {
        int ans = 0;
        int toCopy = Math.min(n, left);
        System.arraycopy(this.buf, 0, buf, 0, toCopy);
        System.arraycopy(this.buf, toCopy, this.buf, 0, left - toCopy);
        ans += toCopy;
        this.left = this.left - toCopy;

        while (ans < n) {
            int left = read4(this.buf);
            if (left == 0) break;

            toCopy = Math.min(n - ans, left);
            System.arraycopy(this.buf, 0, buf, ans, toCopy);
            System.arraycopy(this.buf, toCopy, this.buf, 0, left - toCopy);
            ans += toCopy;
            this.left = left - toCopy;
        }

        return ans;
    }
}