package leetcode.leetcode17xx.leetcode1717;

public class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        char[] arr = new char[n];
        int arrLength = 0, ans = 0;
        char first = x > y ? 'a' : 'b', second = x > y ? 'b' : 'a';
        int cost1 = Math.max(x, y);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == second && arrLength > 0 && arr[arrLength] == first) {
                ans += cost1;
                arrLength--;
            } else arr[arrLength++] = c;
        }

        int cost2 = Math.min(x, y);
        for (int i = 0, secondLength = 0; i < arrLength; i++) {
            if (arr[i] == second) secondLength++;
            else if (arr[i] == first) {
                if (secondLength > 0) {
                    ans += cost2;
                    secondLength--;
                }
            } else secondLength = 0;
        }
        return ans;
    }
}
