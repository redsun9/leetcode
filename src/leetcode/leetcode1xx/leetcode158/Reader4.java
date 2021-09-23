package leetcode.leetcode1xx.leetcode158;

public class Reader4 {
    private int pos = 0;
    private int n;
    private char[] arr;

    Reader4(char[] arr) {
        this.n = arr.length;
        this.arr = arr;
    }


    int read4(char[] buf) {
        int ans = Math.min(4, n - pos);
        System.arraycopy(arr, pos, buf, 0, ans);
        pos += ans;
        return ans;
    }
}
