package leetcode.leetcode168;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            n--;
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;
            if (n == 0) break;
        }
        return sb.toString();
    }
}
