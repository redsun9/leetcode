package leetcode.leetcode2xx.leetcode299;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        int n = secret.length();
        for (int i = 0; i < n; i++) {
            int a = secret.charAt(i) - '0';
            int b = guess.charAt(i) - '0';
            if (a == b) bulls++;
            else {
                count1[a]++;
                count2[b]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(count1[i], count2[i]);
        }
        return "" + bulls + 'A' + cows + 'B';
    }
}
